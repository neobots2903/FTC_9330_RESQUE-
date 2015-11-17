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
 //   DcMotor motorSweeper;

//    Servo servoDoor1;
//    Servo servoDoor2;

/*    double Down_Position = 0.6;
    double Up_Position = 0.4;
    double Current_Position = 0.5;
*/
    @Override
    public void init() {
        //get references to the motors from the hardware map
        motorFL = hardwareMap.dcMotor.get("motor_front_left");
        motorBL = hardwareMap.dcMotor.get("motor_back_left");
        motorFR = hardwareMap.dcMotor.get("motor_front_right");
        motorBR = hardwareMap.dcMotor.get("motor_back_right");
//        motorSweeper = hardwareMap.dcMotor.get("motorSweeper");
        //reverse the left motor
        motorFR.setDirection(DcMotor.Direction.REVERSE);
        motorBL.setDirection(DcMotor.Direction.REVERSE);
        //Map Servos and give them a value.

//        servoDoor1 = hardwareMap.servo.get("Door1");
//       servoDoor2 = hardwareMap.servo.get("Door2");
    }

    @Override
    public void loop() {

        //get the values from the gamepads
        //note: pushing the stick all the way up returns -1,
        // so we need to reverse the values
        float leftY = -gamepad1.left_stick_y;
        float rightY = -gamepad1.right_stick_y;

        //set the power of the motors with the gamepad values
        motorFL.setPower(leftY);
        motorBL.setPower(leftY);
        motorFR.setPower(rightY);
        motorBR.setPower(rightY);

        //Set up the on, off, and reverse function on the sweeper
/*(        if(gamepad1.a){
            motorSweeper.setPower(100);
        }
        else if (gamepad1.b){
            motorSweeper.setPower(-100);
        }
        else{
            motorSweeper.setPower(0);
       }*/

        //Use of the servos is below, we will be having a open close system.
 /*       if (gamepad1.x){
            servoDoor1.setPosition(Down_Position);
            while(gamepad1.x){

            }

        }
        else {
            servoDoor1.setPosition(Up_Position);
        }
        if (gamepad1.y){
            servoDoor2.setPosition(Down_Position);
            while (gamepad1.y){

            }

        }
        else {
            servoDoor2.setPosition(Up_Position);
        } */
    }
}

