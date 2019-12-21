package com.github.callmewaggs;

import com.github.callmewaggs.chickenpos.ChickenPOS;

public class Application {
  public static void main(String[] args) {
    ChickenPOS chickenPOS = new ChickenPOS();
    chickenPOS.start();
  }
}
