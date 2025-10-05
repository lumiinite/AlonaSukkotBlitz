package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;

import org.firstinspires.ftc.robotcore.external.navigation.Orientation;

@TeleOp(name="FieldCentricTeleop", group="Teleop")
public class FieldCentricTele extends LinearOpMode {
    private DcMotor frontLeft, frontRight, backLeft, backRight;
    private final double SLOW_MODE = 0.3;
    private final double FAST_MODE = 1;
    private double modeCheck=1; // can prob not init but its better to start automatically in fast

    private BNO055IMU imu;

    public void initMotors(){
        frontLeft  = hardwareMap.get(DcMotor.class, "frontLeft");
        frontRight = hardwareMap.get(DcMotor.class, "frontRight");
        backLeft   = hardwareMap.get(DcMotor.class, "backLeft");
        backRight  = hardwareMap.get(DcMotor.class, "backRight");

        frontLeft.setDirection(DcMotor.Direction.REVERSE);
        backLeft.setDirection(DcMotor.Direction.REVERSE);
    }

    public void initIMU(){
        imu = hardwareMap.get(BNO055IMU.class, "imu");
        BNO055IMU.Parameters parameter = new BNO055IMU.Parameters();
        parameter.angleUnit = BNO055IMU.AngleUnit.DEGREES;
        imu.initialize(parameter);
    }

    @Override
    public void runOpMode() throws InterruptedException {
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

            Orientation angles = imu.getAngularOrientation();
            double heading = angles.firstAngle;


            double cosAngle = Math.toRadians(Math.cos(heading)); //better like this to show telemetry in degrees(?)
            double sinAngle = Math.toRadians(Math.sin(heading));


            double fX = spdx * cosAngle - spdy * sinAngle;
            double fY = spdx * sinAngle + spdy * cosAngle;


            double mathdenom = Math.max(Math.abs(fY) + Math.abs(fX) + Math.abs(rotate), 1);
            double flPower = (fY + fX + rotate)/mathdenom;
            double blPower = (fY - fX + rotate)/mathdenom;
            double frPower = (fY - fX - rotate)/mathdenom;
            double brPower = (fY + fX  - rotate)/mathdenom;

            frontLeft.setPower(flPower);
            backLeft.setPower(blPower);
            frontRight.setPower(frPower);
            backRight.setPower(brPower);

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
