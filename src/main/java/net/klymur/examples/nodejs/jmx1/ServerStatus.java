package net.klymur.examples.nodejs.jmx1;

import org.graalvm.polyglot.HostAccess;

public class ServerStatus implements ServerStatusMBean {
@HostAccess.Export
  public ServerStatus() {
    nRequestsFailed = 0;
    nRequestsSucceeded = 0;
  }

  private int nRequestsFailed;
  private int nRequestsSucceeded;

@HostAccess.Export
  @Override
  public int getNumberOfApiRequests() {
    return nRequestsFailed + nRequestsSucceeded;
  }

@HostAccess.Export
  @Override
  public int getNumberOfApiRequestsFailed() {
    return nRequestsFailed;
  }

@HostAccess.Export
  @Override
  public int getNumberOfApiRequestsSucceeded() {
    return nRequestsSucceeded;
  }

@HostAccess.Export
  public void incrementNumberOfApiRequestsFailed() {
    nRequestsFailed++;
  }

@HostAccess.Export
  public void incrementNumberOfApiRequestsSucceeded() {
    nRequestsSucceeded++;
  }
}
