package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
/**
 * Created by robot on 11/14/2015.
 */
public class OpAParkRed extends OpMode {

    DcMotor motorFL;
    DcMotor motorBL;
    DcMotor motorFR;
    DcMotor motorBR;

    double time = getRuntime();

    @Override
    public void init() {

        motorFL = hardwareMap.dcMotor.get("motorFL");
        motorBL = hardwareMap.dcMotor.get("motorBL");
        motorFR = hardwareMap.dcMotor.get("motorFR");
        motorBR = hardwareMap.dcMotor.get("motorBR");

        motorFL.setDirection(DcMotor.Direction.REVERSE);
        motorBL.setDirection(DcMotor.Direction.REVERSE);

    }

    @Override
    public void loop() {
    while(time-500 < 0){

        motorFL.setPower(0);
        motorBL.setPower(0);
        motorFR.setPower(50);
        motorBR.setPower(50);

        }
        while(time-4500 < 0) {
            motorFL.setPower(50);
            motorBL.setPower(50);
            motorFR.setPower(50);
            motorBR.setPower(50);
        }
        motorFL.setPower(0);
        motorBL.setPower(0);
        motorFR.setPower(0);
        motorBR.setPower(0);
    }
}
