package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp

public class NrTeleOp extends LinearOpMode {
    public void runOpMode(){
       DcMotor right1;
       DcMotor left1;
       DcMotor right2;
       DcMotor left2;
       DcMotor core;
       Servo claws;
       Servo pilos;
       DcMotor arm;
      
        telemetry.addData("Button", "Running");
        telemetry.addData("Status", "Didn't press");
        //telemetry.update();
        
        waitForStart();


        while(opModeIsActive()){//озучування елементів
        
            right1 = hardwareMap.get(DcMotor.class, "right1");
            right2 = hardwareMap.get(DcMotor.class, "right2");
            left1 = hardwareMap.get(DcMotor.class, "left1"); 
            left2 = hardwareMap.get(DcMotor.class, "left2");
            left1.setDirection(DcMotor.Direction.REVERSE);
            
            core = hardwareMap.get(DcMotor.class,"core");
            claws = hardwareMap.get(Servo.class, "claws");
            
            arm = hardwareMap.get(DcMotor.class, "arm");

         
            double forward = -gamepad1.left_stick_y;
            double strafe = gamepad1.left_stick_x;
            double rotate = gamepad1.right_stick_x;
            //claws.setPower(0.2);
           // right1.setPower((forward-strafe-rotate)*0.7);
           // left1.setPower((forward+strafe+rotate)*0.6);
           // right2.setPower((forward+strafe-rotate)*0.6);
           // left2.setPower((forward-strafe+rotate)*0.6);
            
            right1.setPower((forward-strafe-rotate));
            left1.setPower((forward+strafe+rotate));
            right2.setPower((forward+strafe-rotate));
            left2.setPower((forward-strafe+rotate));
            

            //pilos.setPosition(gamepad1.left_trigger);
            // pilos.setPosition(0.0);
              
              
             if (gamepad1.left_bumper){  //клешня
                 claws.setPosition(0);
              }
              else{
                  claws.setPosition(0.3);
              }
              
              
              
              // Pylosos
              /*if (gamepad1.dpad_up){
                  pilos.setPower(1);
              }
              else if (gamepad1.dpad_down){
                  pilos.setPower(-1);
              }
             else {
                pilos.setPower(0); 
              }
          
              while(gamepad1.right_bumper){
                  pilos.setPosition(1);
              }
             */
             
             
           
        if (gamepad1.y){// рука
            arm.setPower(0.9);
        }
        else if (gamepad1.a){
            arm.setPower(-0.7);
        }
        else {
            arm.setPower(0);
            arm.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        }
        if (gamepad1.x){//розкидання вертелк
           core.setPower(0.6);
        }
        else if (gamepad1.b){ 
            core.setPower(-0.6);
        }
        else {
            core.setPower(0);
            core.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
            
        }
       
    }
}
}


