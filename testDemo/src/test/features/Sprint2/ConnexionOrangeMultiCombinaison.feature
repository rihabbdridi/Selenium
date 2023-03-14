@tag
Feature: Connexion Orange Multi choix
  on va essayer de se connecter en entrant differentes combinaisons passante et non passante

  @tag2
  Scenario Outline: Authentification Site Orange
    Given Ouvrir site avec URL
    When Entrer userlogin<MAIL>
    And Entrer userpassword<MDP>
    And Clique button se connecter
    Then acces compte

    Examples: 
      | MAIL    | MDP      |
      | Admin   | admin123 |
      | Admmii  | admin000 |
      | Admin   | admin    |
      | Admmii2 | admin123 |
