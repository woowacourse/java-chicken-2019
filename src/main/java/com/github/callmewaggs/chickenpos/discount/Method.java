package com.github.callmewaggs.chickenpos.discount;

public enum Method {
  CARD(1),
  CASH(2);

  int method;

  Method(int method) {
    this.method = method;
  }

  public boolean equalTo(int method) {
    return this.method == method;
  }
}
