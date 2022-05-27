package ch15;

import java.io.*;
import java.util.Locale;
import java.util.Scanner;

public class PipedReaderWriter {
    public static void main(String[] args) {
        InputThread inThread = new InputThread("InputThread");
        OutputThread outThread = new OutputThread("OutputThread");

        // Piped Reader 와 Piped Writer 를 연결한다.
        inThread.connect(outThread.getOutput());

        inThread.start();
        outThread.start();
    }
}

// 쓰레드 입력용
class InputThread extends Thread {

    PipedReader input = new PipedReader();
    StringWriter sw = new StringWriter();

    public InputThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        try {
            int data = 0;
            while ((data = input.read()) != -1) {
                sw.write(data);
            }
            System.out.println(this.getName() + " received : " + sw.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public PipedReader getInput() {
        return input;
    }

    public void connect(PipedWriter output) {
        System.out.println("입력 쓰레드의 connect 메서드 호출");
        try {
            input.connect(output);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

// 쓰레드 출력용
class OutputThread extends Thread {

    PipedWriter output = new PipedWriter();

    public OutputThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        try {
            String msg = "Hello";
            System.out.println(this.getName() + " sent : " + msg);
            output.write(msg);
            output.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public PipedWriter getOutput() {
        return output;
    }

    public void connect(PipedReader input) {
        System.out.println("출력 쓰레드의 connect 메서드 호출");
        try {
            output.connect(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}