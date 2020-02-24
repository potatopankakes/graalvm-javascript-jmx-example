const nconf = require('nconf')
const process = require('process')
const express = require('express')
const http = require('http')

nconf.argv().env()
const app = express()
const server = http.createServer(app)

// Create the JMX objects
const ObjectName = Java.type('javax.management.ObjectName')
const objectName = new ObjectName('net.klymur.examples.nodejs.jmx1:name=ServerStatus')

const ServerStatus = Java.type('net.klymur.examples.nodejs.jmx1.ServerStatus')
const serverStatus = new ServerStatus();

// Wire in the MBean to JMX
const ManagementFactory = Java.type('java.lang.management.ManagementFactory')
const platformMBeanServer = ManagementFactory.getPlatformMBeanServer()
platformMBeanServer.registerMBean(serverStatus, objectName);

// Handler for the / endpoint
app.get('/', (req, res) => {
  const max = 100;
  const randId = Math.floor(Math.random() * max)
  let success = true

  try {
    // Fail for ~25% of the requests
    if (randId < max / 4) {
      throw new Error('Unlucky Number...  :-(')
    }

    // send the success response
    res.send({ message: 'Lucky Number!  :-)', number: randId })

    // increment the JMX metric
    serverStatus.incrementNumberOfApiRequestsSucceeded()
  } catch (error) {
    success = false // not for the request log

    // send the error response
    res
      .status(500)
      .send({ message: error.message, number: randId })
    
    // increment the JMX metric
    serverStatus.incrementNumberOfApiRequestsFailed()
  }

  // log message of request/response
  console.log({ msg: 'Request', number: randId, success })
})

// start the server and print on startup
const options = {
  port: nconf.get('port') || 3000,
  host: nconf.get('address') || '127.0.0.1',
  exclusive: true
}
server.listen(options, (error) => {
  if (error) {
    console.error({ msg: 'Failed listening', ...options })
    process.exit(1);
  }
  console.log({ msg: 'Listening', ...server.address() })
})
