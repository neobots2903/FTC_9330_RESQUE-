package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

public class BrandonFTC15Tele extends OpMode {
    // Mapping of the motors here.
    DcMotor motorFL;
    DcMotor motorBL;
    DcMotor motorFR;
    DcMotor motorBR;
    DcMotor motorLever;
    DcMotor motorArm;
    //Set servo's
    Servo servoDoor1;
    Servo servoDoor2;

    double upPosition1 = 0.0;
    double downPosition1 = 0.6;
    double upPosition2 = 0.6;
    double downPosition2 = 0.0;
    boolean DoorUp1 = false;
    boolean DoorUp2 = false;

    @Override
    public void init() {
        //get references to the motors from the hardware map
        motorFL = hardwareMap.dcMotor.get("motorFL");
        motorBL = hardwareMap.dcMotor.get("motorBL");
        motorFR = hardwareMap.dcMotor.get("motorFR");
        motorBR = hardwareMap.dcMotor.get("motorBR");
        motorLever = hardwareMap.dcMotor.get("motorLever");
        motorArm = hardwareMap.dcMotor.get("motorArm");

        //reverse the left motor
        motorFL.setDirection(DcMotor.Direction.REVERSE);
        motorBL.setDirection(DcMotor.Direction.REVERSE);
        motorArm.setDirection(DcMotor.Direction.REVERSE);
        motorLever.setDirection(DcMotor.Direction.REVERSE);
        //Map Servos and give them a value.
        servoDoor1 = hardwareMap.servo.get("Door1");
        servoDoor2 = hardwareMap.servo.get("Door2");
    }

    @Override
    public void loop() {
        //get the values from the gamepads
        //note: pushing the stick all the way up returns -1,
        // so we need to reverse the values
        double leftY1 = -gamepad1.left_stick_y;
        double rightY1 = -gamepad1.right_stick_y;
        double leftY2 = -gamepad2.left_stick_y;
        double rightY2 = -gamepad2.right_stick_y;
        //set the power of the motors with the gamepad values
        motorFL.setPower(leftY1 * .5);
        motorBL.setPower(leftY1 * .5);
        motorFR.setPower(rightY1 * .5);
        motorBR.setPower(rightY1 * .5);

        motorLever.setPower(Math.abs(leftY2) * leftY2 * 0.6);
        motorArm.setPower(Math.abs(rightY2) * rightY2 * 0.6);

        if(gamepad2.x){
            DoorUp1 = !DoorUp1;
        }

        if (gamepad2.y){
            DoorUp2 = !DoorUp2;
        }

        if (DoorUp1) {
            servoDoor1.setPosition(downPosition1);
        } else {
            servoDoor1.setPosition(upPosition1);
        }
        if (DoorUp2){
            servoDoor2.setPosition(downPosition2);
        }
        else{
            servoDoor2.setPosition(upPosition2);
        }
    }
}

