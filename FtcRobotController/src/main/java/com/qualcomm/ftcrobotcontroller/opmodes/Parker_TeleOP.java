package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by robot on 11/11/2015.
 */
public class Parker_TeleOP extends OpMode {
    DcMotor motorLeft;
    DcMotor motorRight;
    //DcMotor motorWWIII;

//    Servo servoDoor1;
  //  Servo servoDoor2;
//    double Down_Position = 0.6;
//    double Up_Positon = 0.4;
//    double Current_Position = 0.5;
//    boolean isOpen1 = false;
//    boolean isOpen2 = false;

    @Override
    public void init() {

        motorLeft = hardwareMap.dcMotor.get("motorLeft");
        motorRight = hardwareMap.dcMotor.get("motorRight");
        //motorWWIII = hardwareMap.dcMotor.get("motorWWIII");
        //set the left drive motor into reverse
        motorRight.setDirection(DcMotor.Direction.REVERSE);
//        servoDoor1 = hardwareMap.servo.get("servoDoor1");
//        servoDoor2 = hardwareMap.servo.get("servoDoor1");

    }

    @Override
    public void loop() {
        float leftY = -gamepad1.left_stick_y;
        float rightY = -gamepad1.right_stick_y;

        motorLeft.setPower(leftY);
        motorRight.setPower(rightY);
  //      if(gamepad1.a){
            //motorWWIII.setPower(100);
 //       }
//         else if (gamepad1.b){
            //motorWWIII.setPower(-100);
//        }
//        else{
            //motorWWIII.setPower(0);
//        }
 //       if(gamepad1.x){
//            if (isOpen1){
//                servoDoor1.setPosition(Down_Position);
 //           }
 //           else {
//                servoDoor1.setPosition(Up_Positon);
//                isOpen1 = !isOpen1;
  //          }
 //       }
//        if (gamepad1.y){
 //           if (isOpen2){
 //               servoDoor2.setPosition(Down_Position);
 //           }
 //           else {
 //               servoDoor2.setPosition(Up_Positon);
   //             isOpen2 = !isOpen2;
   //         }
     //   }
    }
}
