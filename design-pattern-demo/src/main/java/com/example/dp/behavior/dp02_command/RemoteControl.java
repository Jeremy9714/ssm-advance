package com.example.dp.behavior.dp02_command;

/**
 * @Description: 调用者类
 * @Author: Chenyang on 2025/04/23 18:47
 * @Version: 1.0
 */
public class RemoteControl {
    private Command command;

//    public RemoteControl(Command command) {
//        this.command = command;
//    }

    public void setCommand(Command command) {
        this.command = command;
    }

    public void pressButton() {
        command.execute();
    }

    public static void main(String[] args) {
        Light light = new Light();
        LightOnCommand lightOnCommand = new LightOnCommand(light);
        LightOffCommand lightOffCommand = new LightOffCommand(light);
        RemoteControl control = new RemoteControl();
        control.setCommand(lightOnCommand);
        control.pressButton();

        control.setCommand(lightOffCommand);
        control.pressButton();
    }
}
