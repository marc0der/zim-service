Feature: Invader Quotes

  Scenario: Invader Zim quotes by Name
    Given invader "Zim" says "The Earth is safe! I did it, GIR! Now let's go destroy it!"
    When a quote is requested for "Zim"
    Then the status is 200
    And we receive "The Earth is safe! I did it, GIR! Now let's go destroy it!"

  Scenario: Invader GIR quotes by Name
    Given invader "GIR" says "Can I be a mongoose dog?"
    When a quote is requested for "GIR"
    Then the status is 200
    And we receive "Can I be a mongoose dog?"

  Scenario: No Invader is found
    When a quote is requested for "DIB"
    Then the status is 404
