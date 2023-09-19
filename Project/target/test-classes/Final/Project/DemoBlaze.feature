@tag
Feature: To verify the URL for Demo_blaze on Google browser


#Testcase 1: for launch the url via chrome 
  #@tag1
  Scenario: Verify the DemoBlaze URL
  Given launching the homepage
#
#Testcase 2: Launch the Site and Validate   
   #@tag1
  Scenario: Launch the DemoBlaze/ PRODUCT STORE and Verify the Homepage 
  Given launching the homepage  
  And Verify the site is working properly
  #
  #Testcase 3: Launch the Site and do the registration  
  #@tag2
  Scenario: Verify the DemoBlaze URL with Login with funtionality with Greeting message  to the user.
    Given launching the homepage
     And User Clicks  on the SignUp Button
    When I pass the "<username>" and "<password>"
    And User should be create the account successfully.
    And User should be landed to the HomePage
     Examples: 
      | username              | password         |
      | nagoor11							| test1234         | 
       
      
      
      
    
    #Testcase 4: Launch the Site and login   
  #@tag2
  Scenario: Verify the DemoBlaze URL with Login with funtionality with Greeting message  to the user.
    Given launching the homepage
     And User Clicks  on the Login Button
    When I enter "nagoor" and "meeran"
    And User should be logged in and greeting message should be displayed 
   
    
    
    
    
