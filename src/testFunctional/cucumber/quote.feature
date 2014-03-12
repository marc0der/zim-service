Feature: Invader Quotes

  Scenario: An Invader quotes by Name
    Given an Invader named "gir"
    And an Invader named "zim"
    And the Invader "gir" has a quote "Can I be a mongoose dog?"
    And the Invader "zim" has a quote "The Earth is safe! I did it, GIR! Now let's go destroy it!"
    When a Quote is requested for "gir"
    Then we hear "Can I be a mongoose dog?"