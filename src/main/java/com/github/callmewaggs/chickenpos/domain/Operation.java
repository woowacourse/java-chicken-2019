package com.github.callmewaggs.chickenpos.domain;

public enum Operation {
  ORDERING(1),
  PAYMENT(2),
  EXIT(3);

  private final int operation;

  Operation(int operation) {
    this.operation = operation;
  }

  public boolean compareTo(int value) {
    return operation == value;
  }
}
