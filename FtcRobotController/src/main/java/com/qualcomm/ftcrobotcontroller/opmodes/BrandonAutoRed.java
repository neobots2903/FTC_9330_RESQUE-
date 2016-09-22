package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

/**
 * Created by drlove on 11/21/2015.
 */
public class BrandonAutoRed extends LinearOpMode{
    DcMotor motorFL;
    DcMotor motorBL;
    DcMotor motorFR;
    DcMotor motorBR;
    double time = getRuntime();

    @Override
    public void runOpMode() throws InterruptedException {
        motorFL = hardwareMap.dcMotor.get("motorFL");
        motorBL = hardwareMap.dcMotor.get("motorBL");
        motorFR = hardwareMap.dcMotor.get("motorFR");
        motorBR = hardwareMap.dcMotor.get("motorBR");
        motorFR.setDirection(DcMotor.Direction.REVERSE);
        motorBL.setDirection(DcMotor.Direction.REVERSE);

        waitForStart();
        motorFL.setPower(0);
        motorBL.setPower(0);
        motorFR.setPower(0);
        motorBR.setPower(0);
        sleep(100);
        motorFL.setPower(-0.5);
        motorBL.setPower(-0.5);
        motorFR.setPower(-0.5);
        motorBR.setPower(-0.5);
        sleep(2000);
        motorFL.setPower(0.5);
        motorBL.setPower(0.5);
        motorFR.setPower(-0.5);
        motorBR.setPower(-0.5);
        sleep(750);
        motorFL.setPower(-0.5);
        motorBL.setPower(-0.5);
        motorFR.setPower(-0.5);
        motorBR.setPower(-0.5);
        sleep(2000);
        motorFL.setPower(0);
        motorBL.setPower(0);
        motorFR.setPower(0);
        motorBR.setPower(0);
    }
}
