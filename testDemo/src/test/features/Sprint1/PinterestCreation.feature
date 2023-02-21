
@tag
Feature: Creation Pinterest
  creation compte 

  @tag1
  Scenario: inscription Pinterest
    Given ouvrir le navigateur
    And ouvrir URL du site
    And Cliquer sur s inscrire
    When Entrer Mail
    And Entrer mot de passe
    And Saisir age
    And cliquer sur continuer
    And cliquer sur  suivant
    And Choisir genre
    And Choisir Langue
    And Choisir pays
    And cliquer suivant
    And Choisir theme
    And Choisir termine
    Then Verifier creation
   
