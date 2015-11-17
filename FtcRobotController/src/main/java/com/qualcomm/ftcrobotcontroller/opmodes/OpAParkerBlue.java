package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

/**
 * Created by robot on 11/14/2015.
 */
public class OpAParkerBlue  extends OpMode {
    DcMotor motorLeft;
    DcMotor motorRight;
    DcMotor motorWWIII;

    double time = getRuntime();

    @Override
    public void init() {

        motorLeft = hardwareMap.dcMotor.get("motorLeft");
        motorRight = hardwareMap.dcMotor.get("motorBL");
        motorWWIII = hardwareMap.dcMotor.get("motorFR");

        motorLeft.setDirection(DcMotor.Direction.REVERSE);

    }

    @Override
    public void loop() {
        while(time-500 < 0){

            motorLeft.setPower(50);
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
