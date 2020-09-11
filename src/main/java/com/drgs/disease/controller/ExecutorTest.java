package com.drgs.disease.controller;

import lombok.SneakyThrows;
import lombok.Synchronized;
import org.apache.poi.ss.formula.functions.T;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorTest {

    static class thread_1000 implements Runnable{

        @Override
        public void run() {
            System.out.println("1000-1");

            System.out.println("1000-2");
        }
    }
    static class thread_5000 implements Runnable{

        @Override
        public void run() {
            System.out.println("5000-1");

            System.out.println("5000-2");
        }
    }
    static class thread_10000 implements Runnable{

        @SneakyThrows
        @Override
        public void run() {
            System.out.println("10000-1");
            Thread.sleep(5000);
            System.out.println("10000-2");
        }
    }
    public static void main(String[] args) {
        System.out.println(ExecutorTest.test());
    }
    static boolean test(){
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        cachedThreadPool.execute(new Runnable() {
            @SneakyThrows
            @Override
            @Synchronized
            public void run() {
                System.out.println("0");
                Thread.sleep(5000);
                System.out.println("5");
            }
        });
        cachedThreadPool.execute(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {

            }
        });
        cachedThreadPool.shutdown();
        return true;
    }
}
