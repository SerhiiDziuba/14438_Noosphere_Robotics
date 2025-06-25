package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Autonomous

public class AutoOneSample extends LinearOpMode {

    
    private DcMotor right1;
    private DcMotor right2;
    private DcMotor left1;
    private DcMotor left2;
    private Servo claws;
    private DcMotor arm;
    //private Servo Vsos;
    //private Servo blockclaw;

    @Override
    public void runOpMode() {
        left2 = hardwareMap.get(DcMotor.class, "left2");
        right2 = hardwareMap.get(DcMotor.class, "right2");
        left1 = hardwareMap.get(DcMotor.class, "left1");
        right1 = hardwareMap.get(DcMotor.class, "right1");
        left1.setDirection(DcMotor.Direction.REVERSE);
        claws = hardwareMap.get(Servo.class, "claws");
        arm = hardwareMap.get(DcMotor.class, "arm");
        //Vsos = hardwareMap.get(Servo.class, "Vsos");
        //blockclaw = hardwareMap.get(Servo.class, "blockclaw");

        right1.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        left1.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        right2.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        left2.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        waitForStart();

        if (opModeIsActive()) {
            
            claws.setPosition(0.35);
            sleep(2000);
            handUp(1800);
            driveForward(100);
            sleep(500);
            stopMotors(); 
            driveLeft(1200) ;
            stopMotors(); 
           //sleep(1300);
           driveForward(285);//330
           
          stopMotors(); 
           handDown();
           sleep(350);
           claws.setPosition(0);
           
         
           driveBack(700);//800
           stopMotors(); 
           //handUp(1100);
          driveRight(1900);
           
           
            //driveBack();
           //stopMotors(); 
            //driveRight();
         
           /* 
            if ( right1.getCurrentPosition() < 4000) {
                driveForward();
                sleep(500);
                showTelemetry();
            }
            */
/*
            stopMotors(); 
            sleep(500);

            while (opModeIsActive() && right1.getCurrentPosition() < 2140) { 
               // turnRight();
                showTelemetry();
            }
*/
           // stopMotors();
         //  while(true)
           //showTelemetry();
        }
    }
    private void handUp(int i) {
    arm.setPower(1);
    sleep(i);
    arm.setPower(0);
    arm.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    //sleep(1400);
    }
    
    private void driveForward(int i) {
        left1.setPower(0.35);
        right1.setPower(0.3);
        left2.setPower(0.3);
        right2.setPower(0.3);
        sleep(i);
    }
        private void driveLeft(int i) {
        left1.setPower(-0.3);
        right1.setPower(0.37);
        left2.setPower(0.3);
        right2.setPower(-0.37);
        sleep(i);
    }
        private void handDown(){
            //sleep(20);
            arm.setPower(-0.8);
            sleep(600);
            //claws.setPosition(0.1);
        }
        private void driveBack(int i){
        left1.setPower(-0.35);
        right1.setPower(-0.3);
        left2.setPower(-0.35);
        right2.setPower(-0.3);
        sleep(i);
        }
        private void driveRight(int i){
        left1.setPower(0.35);
        right1.setPower(-0.3);
        left2.setPower(-0.35);
        right2.setPower(0.3);
        sleep(i);
        }

    private void turnRight() {
       // MotorL1.setPower(0.5);
       // MotorR1.setPower(-0.5);
       // MotorL2.setPower(0.5);
       // MotorR2.setPower(-0.5);
    }

    private void stopMotors() {
        left1.setPower(0);
        right1.setPower(0);
        left2.setPower(0);
        right2.setPower(0);
        sleep(500);
    }

    private void showTelemetry() {
        telemetry.addData("L1:", left1.getCurrentPosition());
        telemetry.addData("R1:", right1.getCurrentPosition());
        telemetry.addData("L2:", left2.getCurrentPosition());
        telemetry.addData("R2:", right2.getCurrentPosition());
        telemetry.update();
    }
}
