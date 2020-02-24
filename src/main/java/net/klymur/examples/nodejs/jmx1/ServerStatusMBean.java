package net.klymur.examples.nodejs.jmx1;

public interface ServerStatusMBean {
  public int getNumberOfApiRequests();
  public int getNumberOfApiRequestsFailed();
  public int getNumberOfApiRequestsSucceeded();
}

