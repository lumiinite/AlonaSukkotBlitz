package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.IMU;

import org.firstinspires.ftc.robotcore.external.navigation.Orientation;

@TeleOp(name="FieldCentricTeleop", group="Teleop")
public class FieldCentricTele extends LinearOpMode {
    private DcMotor leftFront, rightFront, leftBack, rightBack;
    private final double SLOW_MODE = 0.3;
    private final double FAST_MODE = 1;
    private double modeCheck=1; // can prob not init but its better to start automatically in fast

    private IMU imu;

    public void initMotors(){
        leftFront  = hardwareMap.get(DcMotor.class, "leftFront");
        rightFront = hardwareMap.get(DcMotor.class, "rightFront");
        leftBack   = hardwareMap.get(DcMotor.class, "leftBack");
        rightBack  = hardwareMap.get(DcMotor.class, "rightBack");

        leftFront.setDirection(DcMotor.Direction.REVERSE);
        leftBack.setDirection(DcMotor.Direction.REVERSE);
    }

    public void initIMU(){
        imu = hardwareMap.get(IMU.class, "imu");
        IMU.Parameters parameter = new IMU.Parameters(
                new RevHubOrientationOnRobot(
                        RevHubOrientationOnRobot.LogoFacingDirection.RIGHT,
                        RevHubOrientationOnRobot.UsbFacingDirection.BACKWARD
                        )
        );
        imu.initialize(parameter);
    }

    @Override
    public void runOpMode() throws InterruptedException {
        initIMU();
        initMotors();


        waitForStart();
        while(opModeIsActive()){
            if(gamepad1.aWasPressed()){
                if (modeCheck == 1.0) {
                    modeCheck = 0.5;
                } else {
                    modeCheck = 1.0;
                }
            }

            double spdy = -gamepad1.left_stick_y * modeCheck;
            double spdx = gamepad1.left_stick_x  * modeCheck;
            double rotate = gamepad1.right_stick_x * modeCheck;

            double heading = -imu.getRobotYawPitchRollAngles().getYaw();

            double headingRad = Math.toRadians(heading); // so you can keep seeing degrees on telemetry
            double cosAngle = Math.cos(headingRad);
            double sinAngle = Math.sin(headingRad);


            double fX = spdx * cosAngle - spdy * sinAngle;
            double fY = spdx * sinAngle + spdy * cosAngle;


            double mathdenom = Math.max(Math.abs(fY) + Math.abs(fX) + Math.abs(rotate), 1);
            double flPower = (fY + fX + rotate)/mathdenom;
            double blPower = (fY - fX + rotate)/mathdenom;
            double frPower = (fY - fX - rotate)/mathdenom;
            double brPower = (fY + fX  - rotate)/mathdenom;

            leftFront.setPower(flPower);
            leftBack.setPower(blPower);
            rightFront.setPower(frPower);
            rightBack.setPower(brPower);

            telemetry.addData("heading:", heading);
            if(modeCheck == 1.0){  //just for convenience to see actual mode
                telemetry.addData("mode: fast mode", modeCheck );
            }
            else{
                telemetry.addData("mode: slow mode", modeCheck);
            }
            telemetry.update();


        }



    }
}
