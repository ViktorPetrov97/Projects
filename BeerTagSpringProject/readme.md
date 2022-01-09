Markdown
# BeerTag

### Authored by Viktor Petrov

**BeerTag**** :**

It is an open web application for users to which allows them to add, remove and edit beers and to manage their own profiles. In the private part of the application they can menage list of beers they wish to drink and list of beers they have drank.

## Public view of the application:

Anyone who visits the application will have a view of the main index page. There are menus for navigating inside the aplication, short history of beer and info of the developer team.

Public access to all of the beers that have been added to the application, as well as view main features of the beers by clicking on the **&quot;**** [SEARCH A BEER](http://localhost:8080/beers) ****&quot;** button. The main features of a beer are:

- the **name** of the beer;
- how much alcohol it contains **ABV** (alcohol by volume);
- what is the beer's **style** ;

Logged users have additional info such as:

- from which **brewery** it is made;
- in which **country** ;
- as well as optional beers **descriptions** and its **photo**.
- Anyone can also see the **average rating** of each beer that registered users have given for it.

##### If a user (anonimus) wants more rights, he needs to register in the application with the button &quot;[SIGN UP](http://localhost:8080/register_page)&quot;.If the user has already registered, than he/she must log in to his account through the button &quot;Login&quot;.

Once logged in, each user is already authorized to add new beers, edit and delete existing beers. This can be done via the main page ribbon and clicking on the **&quot;Create Beer&quot;** button, or by approaching the specific page of each beer through **&quot;Beer Details&quot;**. Going into each specific page of beer, the registered user has options to modify the data of the same beer by using the **&quot;Update beer&quot;** button or to delete it by **&quot;Delete beer&quot;**. In addition, he gets the right to add **BEER TAGS** , as well as to give the beer rating. Logged-in users also have an option of marking a beer whether they would like to drink it or they have already drunk it with **&quot;**** Add to wish list ****&quot;** and **&quot;Add to drank list&quot;** buttons.

Each _registered user_ has access to their own profile information. _Administrators_ have access to the list of all _registered users_. Each user on his own profile page can find information about himself:
- username;
- email;
- photo;

On the Users page there is edit account as well an **&quot;**** Save ****&quot;** button with which he can modify his own data. **Administrators** can change status of an user from &quot;enable&quot; to &quot;disable&quot; and back.

Every user can log out via the **&quot;Logout&quot;** button. The homepage of the application is also accessible on every page via the **&quot;Home&quot;** button.

BACKEND:

- **JDK** 11
- **IntelliJ IDEA**  **as working tool**
- **SpringMVC** and **SpringBoot** framework
- **Spring Security** for user authorization

UI:

- [Spring MVC Framework](https://spring.io/) with [Thymeleaf](https://www.thymeleaf.org/) template engine.
- [HTML](https://www.tutorialspoint.com/html/index.htm) - markup language.
- [CSS](https://getbootstrap.com/docs/3.4/css/) - style sheet language.
- [Bootstrap](https://getbootstrap.com/)

database:

- [MariaDB](https://mariadb.org/) - database management system.

additional resorces:

- [GitLab](https://gitlab.com/) - for version-control system :
- [Trello](https://trello.com/) - or organizing thework-flow:
![](src\main\resources\static\images\app_scrshots\2020-09-27_3.png)