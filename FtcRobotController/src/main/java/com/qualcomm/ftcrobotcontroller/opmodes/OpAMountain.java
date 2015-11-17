package com.qualcomm.ftcrobotcontroller.opmodes;

/**
 * Created by robot on 11/13/2015.
 */

        import com.qualcomm.robotcore.eventloop.opmode.OpMode;
        import com.qualcomm.robotcore.hardware.DcMotor;
//for when we are on red alliance.
public class OpAMountain extends OpMode {

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
        if (time-500 < 0) {
            motorFL.setPower(25);
            motorBL.setPower(25);
            motorFR.setPower(50);
            motorBR.setPower(50);
        }
        else if (time-2500 < 0) {
            motorFL.setPower(50);
            motorBL.setPower(50);
            motorFR.setPower(50);
            motorBR.setPower(50);
        }
        else if (time-30000 < 0){
            motorFL.setPower(25);
            motorBL.setPower(25);
            motorFR.setPower(50);
            motorBR.setPower(50);
        }
        else{
            motorFL.setPower(50);
            motorBL.setPower(50);
            motorFR.setPower(50);
            motorBR.setPower(50);
        }
    }
}
