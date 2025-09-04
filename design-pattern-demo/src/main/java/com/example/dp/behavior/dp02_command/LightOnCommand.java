package com.example.dp.behavior.dp02_command;

/**
 * @Description: 具体命令
 * @Author: Chenyang on 2025/04/23 18:45
 * @Version: 1.0
 */
public class LightOnCommand implements Command {

    private Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.switchOn();
    }
}
