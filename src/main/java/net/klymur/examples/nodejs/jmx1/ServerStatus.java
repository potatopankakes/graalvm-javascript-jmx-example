package net.klymur.examples.nodejs.jmx1;

public class ServerStatus implements ServerStatusMBean {
  public ServerStatus() {
    nRequestsFailed = 0;
    nRequestsSucceeded = 0;
  }

  private int nRequestsFailed;
  private int nRequestsSucceeded;

  @Override
  public int getNumberOfApiRequests() {
    return nRequestsFailed + nRequestsSucceeded;
  }

  @Override
  public int getNumberOfApiRequestsFailed() {
    return nRequestsFailed;
  }

  @Override
  public int getNumberOfApiRequestsSucceeded() {
    return nRequestsSucceeded;
  }

  public void incrementNumberOfApiRequestsFailed() {
    nRequestsFailed++;
  }

  public void incrementNumberOfApiRequestsSucceeded() {
    nRequestsSucceeded++;
  }
}
