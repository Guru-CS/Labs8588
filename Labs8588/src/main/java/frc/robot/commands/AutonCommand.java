// 10/23/24 AUTON LAB SOLUTION

package frc.robot.commands;


import java.util.function.BooleanSupplier;


import edu.wpi.first.math.kinematics.ChassisSpeeds;
import edu.wpi.first.math.util.Units;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.StartEndCommand;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.subsystems.SwerveSubsystem;
import java.lang.Math;


public class AutonCommand extends SequentialCommandGroup {


    public AutonCommand() {
        addRequirements();


        // define constants
        final double velocityX = 0.2;
        final double velocityY = 0;
        final double omegaRadiansPerSecond = Math.PI/6;


        
    }
}
