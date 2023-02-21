
@TNR
Feature: Creation Facebook
  on va creer un compte Fcbk

  @tag1
  Scenario: Creation compte Facebook
    Given ouvrir navigateur
    And ouvrir l URL
    And Cliquer sur creer nv compte
    When Entrer nom
    And Entrer prenom
    And Entrer email
    And confirmer email
    And entrer mot de passe
    And entrer date de naissance 
    And selectionner genre
    And cliquer inscription 
    Then compte cree
   
