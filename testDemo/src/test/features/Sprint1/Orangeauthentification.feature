
@tag
Feature: Authentification Orange
  Nous allons faire une l authentification du site oragne

  @tag1
  Scenario: Authentification Valide 
    Given Ouvrir URL de l application
    When saisir login
    And  saisir mot de passe
    And  Cliquer sur le bouton se connecter 
    Then Ouvrir page acceuil
   
