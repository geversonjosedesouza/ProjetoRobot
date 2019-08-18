/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.estacio.prii.robot;

import br.estacio.newton.robot.IRobot;
import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author aluno
 */
public class RobotGeverson implements IRobot {

    private String nome;
    private double velocidade;
    private double temperatura;
    private byte status;
    private int power;
    private double velocidadeMaxima;
    private Random geraStatus = new Random();

    public RobotGeverson() {
        byte resultado = (byte) geraStatus.nextInt(6);
        if (resultado != 0) {
            this.status = resultado;
        }
    }

    public RobotGeverson(String nome) {
        this.nome = nome;
        byte resultado = (byte) geraStatus.nextInt(6);
        if (resultado != 0) {
            this.status = resultado;
        }
    }

    public RobotGeverson(String nome, double velocidade, double temperatura, int power, double velocidadeMaxima) {
        this.nome = nome;
        this.velocidade = velocidade;
        this.temperatura = temperatura;
        this.power = power;
        this.velocidadeMaxima = velocidadeMaxima;
        byte resultado = (byte) geraStatus.nextInt(6);
        if (resultado != 0) {
            this.status = resultado;
        }
    }

    @Override
    public String getName() {
        return this.nome;
    }

    @Override
    public void setName(String string) {
        this.nome = string;
    }

    @Override
    public double getSpeed() {
        return this.velocidade;
    }

    @Override
    public double getTemperature() {
        return this.temperatura;
    }

    @Override
    public byte getStatus() {
        return this.status;
    }

    @Override
    public int getPower() {
        return this.power;
    }

    @Override
    public double getMaxSpeed() {
        return this.velocidadeMaxima;
    }

    @Override
    public void setMaxSpeed(double d) {
        this.velocidadeMaxima = d;
    }

    @Override
    public void show() {
        String mostrando = "Nome: " + this.getName();
        mostrando += toString();
        mostrando += " Velocidade: " + this.getSpeed();
        mostrando += " Velocidade Máxima: " + this.getMaxSpeed();
        mostrando += " Temperatura: " + this.getTemperature();
        mostrando += " Carga: " + this.getPower();
        System.out.print(mostrando);
    }

    @Override
    public void stop() {
        this.velocidade = 0.00;
        this.temperatura -= (this.temperatura * 0.1);
    }

    @Override
    public void speedUp(double d) {
        if (this.velocidadeMaxima >= d) {
            this.velocidade += d;
        }
    }

    @Override
    public void speedUp() {
        this.temperatura += this.velocidade * 0.5;
        this.velocidade = (this.velocidade * 0.1);
    }

    @Override
    public void speedDown(double d) {
        if (this.velocidade >= d) {
            this.velocidade -= d;
            this.temperatura -= d * 0.5;
        }
    }

    @Override
    public void brake() {
        this.velocidade -= (this.velocidade * 0.1);
    }

    @Override
    public void standBy() {
        this.velocidade = 0.00;
        this.temperatura = 0.00;
    }

    @Override
    public void exploring() {
        //1=StandBy, 2=Moving, 3=Exploring, 4=Stopped,5-ReturningHome
        byte resultado = (byte) geraStatus.nextInt(6);
        if (this.status == 4) {
            if (resultado != 0 && resultado != 4) {
                this.status = resultado;
            }
        }
        this.temperatura = 20;
    }

    @Override
    public void returning() {
        //1=StandBy, 2=Moving, 3=Exploring, 4=Stopped,5-ReturningHome
        byte resultado = (byte) geraStatus.nextInt(6);
        if (this.status == 2) {
            if (resultado != 0 && resultado != 2) {
                this.status = resultado;
            }
        }
    }

    @Override
    public void charge() {
        int recarga = (this.power + (int) (this.power * 0.1));
        if (recarga <= 100) {
            this.power = recarga;
        }
    }

    @Override
    public void fullCharge() {
        this.power = 100;
        this.temperatura = this.power * 0.25;
    }

    @Override
    public String toString() {
        //1=StandBy, 2=Moving, 3=Exploring, 4=Stopped,5-ReturningHome
        byte resultado = (byte) geraStatus.nextInt(6);
        if (resultado != 0) {
            switch (resultado) {
                case 1:
                    return "Status: StandBy";
                case 2:
                    return "Status: Moving";
                case 3:
                    return "Status: Exploring";
                case 4:
                    return "Status: Stopped";
                case 5:
                    return "Status: ReturningHome";
            }
        }

        return null;
    }

}
