/*
**Зроблено командою Noosphere Robotics #14438
**програміст Амелія
**
**
**Урок 1. Обертання мотора з відповідною швидкістю
**
*/
package org.firstinspires.ftc.teamcode;

//Наступний блок коду передбачає які класи будуть використовуватись
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;


//Обираємо режим TeleOp
@TeleOp 

//створення основного класу 
public class Lesson1 extends LinearOpMode{
    
   //створення об'єкта класу DcMotor з назвою Motor
   DcMotor Motor;

   public void runOpMode(){
     //Підв'язуємо об'єкт до конфігурації
   /*
hardwareMap.get — це метод у FTC SDK, який дозволяє отримати доступ до 
конкретного пристрою (у даному прикладі для мотора) за його назвою і типом.   
HardwareMap є найважливішим класом, що забезпечує спосіб
доступу і управління фізичними компонентами робота.   
*/ 
     Motor = hardwareMap.get(DcMotor.class, "MotorLeft"); 

//Функція, яка очікує натискання кнопки старт на driver hub
     waitForStart(); 
//Наступний код виконується доти не буде натиснута кнопка стоп
     while(opModeIsActive()){
       
// Встановлюємо швидкість обертання мотора 
        Motor.setPower(0.5);            
      }
     }
}
