package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.GyroSensor;
import com.qualcomm.robotcore.hardware.OpticalDistanceSensor;
import com.qualcomm.robotcore.hardware.TouchSensor;
import com.qualcomm.robotcore.util.Range;


public class motor_test extends OpMode {

    DcMotor motor_left;
    DcMotor motor_right;
    OpticalDistanceSensor optic;
    TouchSensor touch;
    ColorSensor colorSensor;
    GyroSensor sensorGyro;
    int xVal, yVal, zVal = 0;
    int heading = 0;

    @Override
    public void init() {
        //get references to the motors from the hardware map
        motor_left = hardwareMap.dcMotor.get("motor_left");
        motor_right = hardwareMap.dcMotor.get("motor_right");
        optic = hardwareMap.opticalDistanceSensor.get("optic");
        touch = hardwareMap.touchSensor.get("touch");
        colorSensor = hardwareMap.colorSensor.get("color");
        //reverse the right motor
        motor_right.setDirection(DcMotor.Direction.REVERSE);
        sensorGyro = hardwareMap.gyroSensor.get("gyro");
        sensorGyro.calibrate();
        while (sensorGyro.isCalibrating()) {
            try {
                Thread.sleep(50);
            }
            catch (Exception ex)
            {;}
        }
    }

    @Override
    public void loop() {
        //Get the values from the gamepads
        //Note: pushing the stick all the way up returns -1,
        // so we need to reverse the y values
        float xValue = gamepad1.left_stick_x;
        float yValue = -gamepad1.left_stick_y;

        //Calculate the power needed for each motor
        float leftPower = yValue + xValue;
        float rightPower = yValue - xValue;

        //Clip the power values so that it only goes from -1 to 1
        leftPower = Range.clip(leftPower, -1, 1);
        rightPower = Range.clip(rightPower, -1, 1);

        //Set the power of the motors with the gamepad values
        motor_left.setPower(leftPower);
        motor_right.setPower(rightPower);

        double reflectance = optic.getLightDetected();
        boolean touchPressed = touch.isPressed();

        telemetry.addData("Reflectance", reflectance);
        telemetry.addData("Touch", touchPressed);
        telemetry.addData("Clear", colorSensor.alpha());
        telemetry.addData("Red  ", colorSensor.red());
        telemetry.addData("Green", colorSensor.green());
        telemetry.addData("Blue ", colorSensor.blue());
           // while (opModeIsActive())  {
                // if the A and B buttons are pressed, reset Z heading.
                if(gamepad1.a && gamepad1.b)  {
                    // reset heading.
                    sensorGyro.resetZAxisIntegrator();
                }

                // get the x, y, and z values (rate of change of angle).
                xVal = sensorGyro.rawX();
                yVal = sensorGyro.rawY();
                zVal = sensorGyro.rawZ();

                // get the heading info.
                // the Modern Robotics' gyro sensor keeps
                // track of the current heading for the Z axis only.
                heading = sensorGyro.getHeading();

                telemetry.addData("1. x", String.format("%03d", xVal));
                telemetry.addData("2. y", String.format("%03d", yVal));
                telemetry.addData("3. z", String.format("%03d", zVal));
                telemetry.addData("4. h", String.format("%03d", heading));

        try {
            Thread.sleep(100);
        }
        catch (Exception ex)
        {;}

        // }
    }
}

