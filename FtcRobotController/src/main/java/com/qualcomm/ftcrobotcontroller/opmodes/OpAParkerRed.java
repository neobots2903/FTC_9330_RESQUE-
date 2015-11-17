package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

/**
 * Created by robot on 11/14/2015.
 */
public class OpAParkerRed extends OpMode {
    DcMotor motorLeft;
    DcMotor motorRight;
    DcMotor motorWWIII;

    double time = getRuntime();

    @Override
    public void init() {

        motorLeft = hardwareMap.dcMotor.get("motorFL");
        motorRight = hardwareMap.dcMotor.get("motorFR");
        motorWWIII = hardwareMap.dcMotor.get("motorWWII");

        motorLeft.setDirection(DcMotor.Direction.REVERSE);
    }

    @Override
    public void loop() {
        while(time-500 < 0){

            motorLeft.setPower(0);
            motorRight.setPower(0);

        }
        while(time-4500 < 0) {
            motorLeft.setPower(50);
            motorRight.setPower(50);
        }
        motorLeft.setPower(0);
        motorRight.setPower(0);
    }
}
