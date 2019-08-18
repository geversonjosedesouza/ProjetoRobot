/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.estacio.prii.robot;

import br.estacio.newton.robot.RobotTest;

/**
 *
 * @author aluno
 */
public class ProgramaTesteRobot {

    public static void main(String[] args) {
        RobotTest rb = new RobotTest(new RobotGeverson(), args);
        rb.mainMenu();
    }
}
