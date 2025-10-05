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
    private double spdMulti = FAST_MODE;
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
        parameter.angleUnit = BNO055IMU.AngleUnit.DEGREES; //unsure about these 2 lines
        imu.initialize(parameter);
    }

    @Override
    public void runOpMode() throws InterruptedException {
        initMotors();

        waitForStart();
        while(opModeIsActive()){
            if(gamepad1.aWasPressed()){
                //--
            }

            double spdy = -gamepad1.left_stick_y;
            double spdx = gamepad1.left_stick_x * 1.1;
            double rotate = gamepad1.right_stick_x;
            Orientation angles = imu.getAngularOrientation();
            double heading = angles.firstAngle;

            double turnX = spdx * Math.cos(-heading) - spdy * Math.sin(-heading);
            double turnY = spdx * Math.sin(-heading) + spdy * Math.cos(-heading);

            double mathdenom = Math.max(Math.abs(spdy) + Math.abs(spdx) + Math.abs(rotate), 1);
            double flPower = (spdy + spdx + rotate) / mathdenom * spdMulti;
            double blPower = (spdy - spdx + rotate) / mathdenom * spdMulti;
            double frPower = (spdy - spdx - rotate) / mathdenom * spdMulti;
            double brPower = (spdy + spdx - rotate) / mathdenom * spdMulti;

            frontLeft.setPower(flPower);
            backLeft.setPower(blPower);
            frontRight.setPower(frPower);
            backRight.setPower(brPower);

            telemetry.addData("Speed mode:", spdMulti);


        }



    }
}
