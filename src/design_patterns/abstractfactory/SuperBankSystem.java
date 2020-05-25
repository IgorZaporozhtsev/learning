package design_patterns.abstractfactory;

import design_patterns.abstractfactory.banking.BankingTeamFactory;
import interview.core.oop.polimorphizm.dynamicPoli.Test;

public class SuperBankSystem {
    public static void main(String[] args) {
        ProjectTeamFactory projectTeamFactory = new BankingTeamFactory();
        Developer developer = projectTeamFactory.getDeveloper();
        Tester tester = projectTeamFactory.getTester();
        ProjectManager projectManager = projectTeamFactory.getProjectManager();

        System.out.println("creating bank system...");

        developer.writeCode();
        tester.testCode();
        projectManager.manageProject();
    }
}
