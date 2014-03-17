Feature: Invader Quotes

  Scenario: An Invader quotes by Name
    Given an Invader named "GIR"
    And an Invader named "Zim"
    And the Invader "GIR" says "Can I be a mongoose dog?"
    And the Invader "Zim" says "The Earth is safe! I did it, GIR! Now let's go destroy it!"
    When a Quote is requested for "GIR"
    Then we hear "Can I be a mongoose dog?"
