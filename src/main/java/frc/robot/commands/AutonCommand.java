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
import frc.robot.subsystems.Indexing;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Shooter;
import frc.robot.subsystems.SwerveSubsystem;
import frc.robot.subsystems.Wrist;
import java.lang.Math;


public class AutonCommand extends SequentialCommandGroup {


    public AutonCommand(SwerveSubsystem driveSubsystem, Intake intake, Indexing indexing, Shooter shooter, Wrist wrist) {
        addRequirements(driveSubsystem);


        // define constants
        final double velocityX = 0.2;
        final double velocityY = 0;
        final double omegaRadiansPerSecond = Math.PI/6;


        addCommands(
            // 1. drive the bot forward for five seconds
                driveSubsystem.run(() -> driveSubsystem.drive(new ChassisSpeeds(velocityX,
                velocityY, 0))).withTimeout(5),
            
            // 2. set the bot to sit still for 1 second
                driveSubsystem.run(() -> driveSubsystem.drive(new ChassisSpeeds(0, 0, 0))).withTimeout(1),

            // 3. drive the bot forward for five seconds, twice as fast
                driveSubsystem.run(() -> driveSubsystem.drive(new ChassisSpeeds(velocityX*2, velocityY, 0))).withTimeout(5),
           
            // 4. spin the robot 180 degrees
                driveSubsystem.run(() -> driveSubsystem.drive(new ChassisSpeeds(0,
                0, omegaRadiansPerSecond))).withTimeout(0.5),
                // stop spinning ans sit still for a second for safety
                driveSubsystem.run(() -> driveSubsystem.drive(new ChassisSpeeds(0, 0, 0))).withTimeout(1),


            // 5. shoot the note
                // begin spinning the shooter
                new ParallelCommandGroup(
                    Commands.runOnce(() -> {
                        // the motor is positioned so that it has to spin backwards to shoot
                        shooter.set(-0.5);
                    })
                ),
                // wait for the shooter to speed up
                new WaitCommand(1),
                // eject the note from the indexer
                new ParallelCommandGroup(
                    Commands.runOnce(() -> {
                        indexing.set(1);
                    })
                ),
                // wait for the note to be fully out of the robot
                new WaitCommand(0.5),
                // shut off both the indexer and the shooter
                new ParallelCommandGroup(
                    Commands.runOnce(() -> {
                        indexing.set(0);
                        shooter.set(0);
                    })
                )
        );
    }
}
