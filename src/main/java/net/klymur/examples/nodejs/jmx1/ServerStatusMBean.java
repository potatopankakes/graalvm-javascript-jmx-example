package net.klymur.examples.nodejs.jmx1;

import org.graalvm.polyglot.HostAccess;

public interface ServerStatusMBean {
@HostAccess.Export
  public int getNumberOfApiRequests();
@HostAccess.Export
  public int getNumberOfApiRequestsFailed();
@HostAccess.Export
  public int getNumberOfApiRequestsSucceeded();
}

