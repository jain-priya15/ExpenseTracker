# ExpenseTracker
Expense Tracker with login/register functionality

### Actor 
- User

#### Cases
As a user I can,
- "Register" with my email and chosen password
- "Login" with my email and password
- "Dashboard" upon login I should see a summary of my expnses in the following format

|Month & Year|Expenses|
|------------|--------|
|Jan 2016|30,000|
|Feb 2016|10,000|
|…And so on|
|Total Expenditure|Xxx INR|
    The footer of the report should display my "Total Expenditure: xxx INR" so far
- **On the dashboard**, I should see following links

                - in the top right corner "logout"
                - below the Expense Summary "add expense"
                - below the Expense Summary "Mail Summary"
                - below the Expense Summary "View all expenses"

- **Add Expense** on clicking on "add expense", I should see a form which captures following stuff

                - Expense title[textbox], Category[select box with values (Electricity, Phone, Internet, Grocery, Food] description[text area], amount[textbox], date[textbox with datepicker integration]
                - An "Add expense" button below the form. Once I click on it, the expense should be saved.
- **Mail Summary** on clicking on "Mail Summary", Whatever Summary is currently visible on page, should be emailed to my email with Subject "Your expenditure so far". This has to be done on background. I don't want to wait on page until that email is actually sent to me.

- **View all Expenses** on clicking view all expenses, I should be able to see a table which list all my expenses so far, in a paginated table. Each entry will display all attributes of an expense, with a link/button to delete that expense next to it. At a time I don't want to see more than 10 rows. Below the table, the footer should display my "Total Expenditure: xxx INR" so far
