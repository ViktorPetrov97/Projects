create table country
(
    country_id   int         not null
        primary key,
    country_name varchar(50) not null,
    constraint country_country_name_uindex
        unique (country_name)
);

INSERT INTO beertag.country (country_id, country_name) VALUES (1, 'Afghanistan');
INSERT INTO beertag.country (country_id, country_name) VALUES (3, 'Albania');
INSERT INTO beertag.country (country_id, country_name) VALUES (4, 'Algeria');
INSERT INTO beertag.country (country_id, country_name) VALUES (5, 'American Samoa');
INSERT INTO beertag.country (country_id, country_name) VALUES (6, 'Andorra');
INSERT INTO beertag.country (country_id, country_name) VALUES (7, 'Angola');
INSERT INTO beertag.country (country_id, country_name) VALUES (8, 'Anguilla');
INSERT INTO beertag.country (country_id, country_name) VALUES (9, 'Antarctica');
INSERT INTO beertag.country (country_id, country_name) VALUES (10, 'Antigua and Barbuda');
INSERT INTO beertag.country (country_id, country_name) VALUES (11, 'Argentina');
INSERT INTO beertag.country (country_id, country_name) VALUES (12, 'Armenia');
INSERT INTO beertag.country (country_id, country_name) VALUES (13, 'Aruba');
INSERT INTO beertag.country (country_id, country_name) VALUES (14, 'Australia');
INSERT INTO beertag.country (country_id, country_name) VALUES (15, 'Austria');
INSERT INTO beertag.country (country_id, country_name) VALUES (16, 'Azerbaijan');
INSERT INTO beertag.country (country_id, country_name) VALUES (17, 'Bahamas');
INSERT INTO beertag.country (country_id, country_name) VALUES (18, 'Bahrain');
INSERT INTO beertag.country (country_id, country_name) VALUES (19, 'Bangladesh');
INSERT INTO beertag.country (country_id, country_name) VALUES (20, 'Barbados');
INSERT INTO beertag.country (country_id, country_name) VALUES (21, 'Belarus');
INSERT INTO beertag.country (country_id, country_name) VALUES (22, 'Belgium');
INSERT INTO beertag.country (country_id, country_name) VALUES (23, 'Belize');
INSERT INTO beertag.country (country_id, country_name) VALUES (24, 'Benin');
INSERT INTO beertag.country (country_id, country_name) VALUES (25, 'Bermuda');
INSERT INTO beertag.country (country_id, country_name) VALUES (26, 'Bhutan');
INSERT INTO beertag.country (country_id, country_name) VALUES (27, 'Bolivia (Plurinational State of)');
INSERT INTO beertag.country (country_id, country_name) VALUES (28, 'Bonaire, Sint Eustatius and Saba');
INSERT INTO beertag.country (country_id, country_name) VALUES (29, 'Bosnia and Herzegovina');
INSERT INTO beertag.country (country_id, country_name) VALUES (30, 'Botswana');
INSERT INTO beertag.country (country_id, country_name) VALUES (31, 'Bouvet Island');
INSERT INTO beertag.country (country_id, country_name) VALUES (32, 'Brazil');
INSERT INTO beertag.country (country_id, country_name) VALUES (33, 'British Indian Ocean Territory');
INSERT INTO beertag.country (country_id, country_name) VALUES (34, 'Brunei Darussalam');
INSERT INTO beertag.country (country_id, country_name) VALUES (35, 'Bulgaria');
INSERT INTO beertag.country (country_id, country_name) VALUES (36, 'Burkina Faso');
INSERT INTO beertag.country (country_id, country_name) VALUES (37, 'Burundi');
INSERT INTO beertag.country (country_id, country_name) VALUES (38, 'Cabo Verde');
INSERT INTO beertag.country (country_id, country_name) VALUES (39, 'Cambodia');
INSERT INTO beertag.country (country_id, country_name) VALUES (40, 'Cameroon');
INSERT INTO beertag.country (country_id, country_name) VALUES (41, 'Canada');
INSERT INTO beertag.country (country_id, country_name) VALUES (42, 'Cayman Islands');
INSERT INTO beertag.country (country_id, country_name) VALUES (43, 'Central African Republic');
INSERT INTO beertag.country (country_id, country_name) VALUES (44, 'Chad');
INSERT INTO beertag.country (country_id, country_name) VALUES (45, 'Chile');
INSERT INTO beertag.country (country_id, country_name) VALUES (46, 'China');
INSERT INTO beertag.country (country_id, country_name) VALUES (47, 'Christmas Island');
INSERT INTO beertag.country (country_id, country_name) VALUES (48, 'Cocos (Keeling) Islands');
INSERT INTO beertag.country (country_id, country_name) VALUES (49, 'Colombia');
INSERT INTO beertag.country (country_id, country_name) VALUES (50, 'Comoros');
INSERT INTO beertag.country (country_id, country_name) VALUES (51, 'Congo');
INSERT INTO beertag.country (country_id, country_name) VALUES (52, 'Congo, Democratic Republic of the');
INSERT INTO beertag.country (country_id, country_name) VALUES (53, 'Cook Islands');
INSERT INTO beertag.country (country_id, country_name) VALUES (54, 'Costa Rica');
INSERT INTO beertag.country (country_id, country_name) VALUES (55, 'Côte d''Ivoire');
INSERT INTO beertag.country (country_id, country_name) VALUES (56, 'Croatia');
INSERT INTO beertag.country (country_id, country_name) VALUES (57, 'Cuba');
INSERT INTO beertag.country (country_id, country_name) VALUES (58, 'Curaçao');
INSERT INTO beertag.country (country_id, country_name) VALUES (59, 'Cyprus');
INSERT INTO beertag.country (country_id, country_name) VALUES (60, 'Czechia');
INSERT INTO beertag.country (country_id, country_name) VALUES (61, 'Denmark');
INSERT INTO beertag.country (country_id, country_name) VALUES (62, 'Djibouti');
INSERT INTO beertag.country (country_id, country_name) VALUES (63, 'Dominica');
INSERT INTO beertag.country (country_id, country_name) VALUES (64, 'Dominican Republic');
INSERT INTO beertag.country (country_id, country_name) VALUES (65, 'Ecuador');
INSERT INTO beertag.country (country_id, country_name) VALUES (66, 'Egypt');
INSERT INTO beertag.country (country_id, country_name) VALUES (67, 'El Salvador');
INSERT INTO beertag.country (country_id, country_name) VALUES (68, 'Equatorial Guinea');
INSERT INTO beertag.country (country_id, country_name) VALUES (69, 'Eritrea');
INSERT INTO beertag.country (country_id, country_name) VALUES (70, 'Estonia');
INSERT INTO beertag.country (country_id, country_name) VALUES (71, 'Eswatini');
INSERT INTO beertag.country (country_id, country_name) VALUES (72, 'Ethiopia');
INSERT INTO beertag.country (country_id, country_name) VALUES (73, 'Falkland Islands (Malvinas)');
INSERT INTO beertag.country (country_id, country_name) VALUES (74, 'Faroe Islands');
INSERT INTO beertag.country (country_id, country_name) VALUES (75, 'Fiji');
INSERT INTO beertag.country (country_id, country_name) VALUES (76, 'Finland');
INSERT INTO beertag.country (country_id, country_name) VALUES (77, 'France');
INSERT INTO beertag.country (country_id, country_name) VALUES (78, 'French Guiana');
INSERT INTO beertag.country (country_id, country_name) VALUES (79, 'French Polynesia');
INSERT INTO beertag.country (country_id, country_name) VALUES (80, 'French Southern Territories');
INSERT INTO beertag.country (country_id, country_name) VALUES (81, 'Gabon');
INSERT INTO beertag.country (country_id, country_name) VALUES (82, 'Gambia');
INSERT INTO beertag.country (country_id, country_name) VALUES (83, 'Georgia');
INSERT INTO beertag.country (country_id, country_name) VALUES (84, 'Germany');
INSERT INTO beertag.country (country_id, country_name) VALUES (85, 'Ghana');
INSERT INTO beertag.country (country_id, country_name) VALUES (86, 'Gibraltar');
INSERT INTO beertag.country (country_id, country_name) VALUES (87, 'Greece');
INSERT INTO beertag.country (country_id, country_name) VALUES (88, 'Greenland');
INSERT INTO beertag.country (country_id, country_name) VALUES (89, 'Grenada');
INSERT INTO beertag.country (country_id, country_name) VALUES (90, 'Guadeloupe');
INSERT INTO beertag.country (country_id, country_name) VALUES (91, 'Guam');
INSERT INTO beertag.country (country_id, country_name) VALUES (92, 'Guatemala');
INSERT INTO beertag.country (country_id, country_name) VALUES (93, 'Guernsey');
INSERT INTO beertag.country (country_id, country_name) VALUES (94, 'Guinea');
INSERT INTO beertag.country (country_id, country_name) VALUES (95, 'Guinea-Bissau');
INSERT INTO beertag.country (country_id, country_name) VALUES (96, 'Guyana');
INSERT INTO beertag.country (country_id, country_name) VALUES (97, 'Haiti');
INSERT INTO beertag.country (country_id, country_name) VALUES (98, 'Heard Island and McDonald Islands');
INSERT INTO beertag.country (country_id, country_name) VALUES (99, 'Holy See');
INSERT INTO beertag.country (country_id, country_name) VALUES (100, 'Honduras');
INSERT INTO beertag.country (country_id, country_name) VALUES (101, 'Hong Kong');
INSERT INTO beertag.country (country_id, country_name) VALUES (102, 'Hungary');
INSERT INTO beertag.country (country_id, country_name) VALUES (103, 'Iceland');
INSERT INTO beertag.country (country_id, country_name) VALUES (104, 'India');
INSERT INTO beertag.country (country_id, country_name) VALUES (105, 'Indonesia');
INSERT INTO beertag.country (country_id, country_name) VALUES (106, 'Iran (Islamic Republic of)');
INSERT INTO beertag.country (country_id, country_name) VALUES (107, 'Iraq');
INSERT INTO beertag.country (country_id, country_name) VALUES (108, 'Ireland');
INSERT INTO beertag.country (country_id, country_name) VALUES (109, 'Isle of Man');
INSERT INTO beertag.country (country_id, country_name) VALUES (110, 'Israel');
INSERT INTO beertag.country (country_id, country_name) VALUES (111, 'Italy');
INSERT INTO beertag.country (country_id, country_name) VALUES (112, 'Jamaica');
INSERT INTO beertag.country (country_id, country_name) VALUES (113, 'Japan');
INSERT INTO beertag.country (country_id, country_name) VALUES (114, 'Jersey');
INSERT INTO beertag.country (country_id, country_name) VALUES (115, 'Jordan');
INSERT INTO beertag.country (country_id, country_name) VALUES (116, 'Kazakhstan');
INSERT INTO beertag.country (country_id, country_name) VALUES (117, 'Kenya');
INSERT INTO beertag.country (country_id, country_name) VALUES (118, 'Kiribati');
INSERT INTO beertag.country (country_id, country_name) VALUES (119, 'Korea (Democratic People''s Republic of)');
INSERT INTO beertag.country (country_id, country_name) VALUES (120, 'Korea, Republic of');
INSERT INTO beertag.country (country_id, country_name) VALUES (121, 'Kuwait');
INSERT INTO beertag.country (country_id, country_name) VALUES (122, 'Kyrgyzstan');
INSERT INTO beertag.country (country_id, country_name) VALUES (123, 'Lao People''s Democratic Republic');
INSERT INTO beertag.country (country_id, country_name) VALUES (124, 'Latvia');
INSERT INTO beertag.country (country_id, country_name) VALUES (125, 'Lebanon');
INSERT INTO beertag.country (country_id, country_name) VALUES (126, 'Lesotho');
INSERT INTO beertag.country (country_id, country_name) VALUES (127, 'Liberia');
INSERT INTO beertag.country (country_id, country_name) VALUES (128, 'Libya');
INSERT INTO beertag.country (country_id, country_name) VALUES (129, 'Liechtenstein');
INSERT INTO beertag.country (country_id, country_name) VALUES (130, 'Lithuania');
INSERT INTO beertag.country (country_id, country_name) VALUES (131, 'Luxembourg');
INSERT INTO beertag.country (country_id, country_name) VALUES (132, 'Macao');
INSERT INTO beertag.country (country_id, country_name) VALUES (133, 'Madagascar');
INSERT INTO beertag.country (country_id, country_name) VALUES (134, 'Malawi');
INSERT INTO beertag.country (country_id, country_name) VALUES (135, 'Malaysia');
INSERT INTO beertag.country (country_id, country_name) VALUES (136, 'Maldives');
INSERT INTO beertag.country (country_id, country_name) VALUES (137, 'Mali');
INSERT INTO beertag.country (country_id, country_name) VALUES (138, 'Malta');
INSERT INTO beertag.country (country_id, country_name) VALUES (139, 'Marshall Islands');
INSERT INTO beertag.country (country_id, country_name) VALUES (140, 'Martinique');
INSERT INTO beertag.country (country_id, country_name) VALUES (141, 'Mauritania');
INSERT INTO beertag.country (country_id, country_name) VALUES (142, 'Mauritius');
INSERT INTO beertag.country (country_id, country_name) VALUES (143, 'Mayotte');
INSERT INTO beertag.country (country_id, country_name) VALUES (144, 'Mexico');
INSERT INTO beertag.country (country_id, country_name) VALUES (145, 'Micronesia (Federated States of)');
INSERT INTO beertag.country (country_id, country_name) VALUES (146, 'Moldova, Republic of');
INSERT INTO beertag.country (country_id, country_name) VALUES (147, 'Monaco');
INSERT INTO beertag.country (country_id, country_name) VALUES (148, 'Mongolia');
INSERT INTO beertag.country (country_id, country_name) VALUES (149, 'Montenegro');
INSERT INTO beertag.country (country_id, country_name) VALUES (150, 'Montserrat');
INSERT INTO beertag.country (country_id, country_name) VALUES (151, 'Morocco');
INSERT INTO beertag.country (country_id, country_name) VALUES (152, 'Mozambique');
INSERT INTO beertag.country (country_id, country_name) VALUES (153, 'Myanmar');
INSERT INTO beertag.country (country_id, country_name) VALUES (154, 'Namibia');
INSERT INTO beertag.country (country_id, country_name) VALUES (155, 'Nauru');
INSERT INTO beertag.country (country_id, country_name) VALUES (156, 'Nepal');
INSERT INTO beertag.country (country_id, country_name) VALUES (157, 'Netherlands');
INSERT INTO beertag.country (country_id, country_name) VALUES (158, 'New Caledonia');
INSERT INTO beertag.country (country_id, country_name) VALUES (159, 'New Zealand');
INSERT INTO beertag.country (country_id, country_name) VALUES (160, 'Nicaragua');
INSERT INTO beertag.country (country_id, country_name) VALUES (161, 'Niger');
INSERT INTO beertag.country (country_id, country_name) VALUES (162, 'Nigeria');
INSERT INTO beertag.country (country_id, country_name) VALUES (163, 'Niue');
INSERT INTO beertag.country (country_id, country_name) VALUES (164, 'Norfolk Island');
INSERT INTO beertag.country (country_id, country_name) VALUES (165, 'North Macedonia');
INSERT INTO beertag.country (country_id, country_name) VALUES (166, 'Northern Mariana Islands');
INSERT INTO beertag.country (country_id, country_name) VALUES (167, 'Norway');
INSERT INTO beertag.country (country_id, country_name) VALUES (168, 'Oman');
INSERT INTO beertag.country (country_id, country_name) VALUES (169, 'Pakistan');
INSERT INTO beertag.country (country_id, country_name) VALUES (170, 'Palau');
INSERT INTO beertag.country (country_id, country_name) VALUES (171, 'Palestine, State of');
INSERT INTO beertag.country (country_id, country_name) VALUES (172, 'Panama');
INSERT INTO beertag.country (country_id, country_name) VALUES (173, 'Papua New Guinea');
INSERT INTO beertag.country (country_id, country_name) VALUES (174, 'Paraguay');
INSERT INTO beertag.country (country_id, country_name) VALUES (175, 'Peru');
INSERT INTO beertag.country (country_id, country_name) VALUES (176, 'Philippines');
INSERT INTO beertag.country (country_id, country_name) VALUES (177, 'Pitcairn');
INSERT INTO beertag.country (country_id, country_name) VALUES (178, 'Poland');
INSERT INTO beertag.country (country_id, country_name) VALUES (179, 'Portugal');
INSERT INTO beertag.country (country_id, country_name) VALUES (180, 'Puerto Rico');
INSERT INTO beertag.country (country_id, country_name) VALUES (181, 'Qatar');
INSERT INTO beertag.country (country_id, country_name) VALUES (182, 'Réunion');
INSERT INTO beertag.country (country_id, country_name) VALUES (183, 'Romania');
INSERT INTO beertag.country (country_id, country_name) VALUES (184, 'Russian Federation');
INSERT INTO beertag.country (country_id, country_name) VALUES (185, 'Rwanda');
INSERT INTO beertag.country (country_id, country_name) VALUES (186, 'Saint Barthélemy');
INSERT INTO beertag.country (country_id, country_name) VALUES (187, 'Saint Helena, Ascension and Tristan da Cunha');
INSERT INTO beertag.country (country_id, country_name) VALUES (188, 'Saint Kitts and Nevis');
INSERT INTO beertag.country (country_id, country_name) VALUES (189, 'Saint Lucia');
INSERT INTO beertag.country (country_id, country_name) VALUES (190, 'Saint Martin (French part)');
INSERT INTO beertag.country (country_id, country_name) VALUES (191, 'Saint Pierre and Miquelon');
INSERT INTO beertag.country (country_id, country_name) VALUES (192, 'Saint Vincent and the Grenadines');
INSERT INTO beertag.country (country_id, country_name) VALUES (193, 'Samoa');
INSERT INTO beertag.country (country_id, country_name) VALUES (194, 'San Marino');
INSERT INTO beertag.country (country_id, country_name) VALUES (195, 'Sao Tome and Principe');
INSERT INTO beertag.country (country_id, country_name) VALUES (196, 'Saudi Arabia');
INSERT INTO beertag.country (country_id, country_name) VALUES (197, 'Senegal');
INSERT INTO beertag.country (country_id, country_name) VALUES (198, 'Serbia');
INSERT INTO beertag.country (country_id, country_name) VALUES (199, 'Seychelles');
INSERT INTO beertag.country (country_id, country_name) VALUES (200, 'Sierra Leone');
INSERT INTO beertag.country (country_id, country_name) VALUES (201, 'Singapore');
INSERT INTO beertag.country (country_id, country_name) VALUES (202, 'Sint Maarten (Dutch part)');
INSERT INTO beertag.country (country_id, country_name) VALUES (203, 'Slovakia');
INSERT INTO beertag.country (country_id, country_name) VALUES (204, 'Slovenia');
INSERT INTO beertag.country (country_id, country_name) VALUES (205, 'Solomon Islands');
INSERT INTO beertag.country (country_id, country_name) VALUES (206, 'Somalia');
INSERT INTO beertag.country (country_id, country_name) VALUES (207, 'South Africa');
INSERT INTO beertag.country (country_id, country_name) VALUES (208, 'South Georgia and the South Sandwich Islands');
INSERT INTO beertag.country (country_id, country_name) VALUES (209, 'South Sudan');
INSERT INTO beertag.country (country_id, country_name) VALUES (210, 'Spain');
INSERT INTO beertag.country (country_id, country_name) VALUES (211, 'Sri Lanka');
INSERT INTO beertag.country (country_id, country_name) VALUES (212, 'Sudan');
INSERT INTO beertag.country (country_id, country_name) VALUES (213, 'Suriname');
INSERT INTO beertag.country (country_id, country_name) VALUES (214, 'Svalbard and Jan Mayen');
INSERT INTO beertag.country (country_id, country_name) VALUES (215, 'Sweden');
INSERT INTO beertag.country (country_id, country_name) VALUES (216, 'Switzerland');
INSERT INTO beertag.country (country_id, country_name) VALUES (217, 'Syrian Arab Republic');
INSERT INTO beertag.country (country_id, country_name) VALUES (218, 'Taiwan, Province of China');
INSERT INTO beertag.country (country_id, country_name) VALUES (219, 'Tajikistan');
INSERT INTO beertag.country (country_id, country_name) VALUES (220, 'Tanzania, United Republic of');
INSERT INTO beertag.country (country_id, country_name) VALUES (221, 'Thailand');
INSERT INTO beertag.country (country_id, country_name) VALUES (222, 'Timor-Leste');
INSERT INTO beertag.country (country_id, country_name) VALUES (223, 'Togo');
INSERT INTO beertag.country (country_id, country_name) VALUES (224, 'Tokelau');
INSERT INTO beertag.country (country_id, country_name) VALUES (225, 'Tonga');
INSERT INTO beertag.country (country_id, country_name) VALUES (226, 'Trinidad and Tobago');
INSERT INTO beertag.country (country_id, country_name) VALUES (227, 'Tunisia');
INSERT INTO beertag.country (country_id, country_name) VALUES (228, 'Turkey');
INSERT INTO beertag.country (country_id, country_name) VALUES (229, 'Turkmenistan');
INSERT INTO beertag.country (country_id, country_name) VALUES (230, 'Turks and Caicos Islands');
INSERT INTO beertag.country (country_id, country_name) VALUES (231, 'Tuvalu');
INSERT INTO beertag.country (country_id, country_name) VALUES (232, 'Uganda');
INSERT INTO beertag.country (country_id, country_name) VALUES (233, 'Ukraine');
INSERT INTO beertag.country (country_id, country_name) VALUES (234, 'United Arab Emirates');
INSERT INTO beertag.country (country_id, country_name) VALUES (235, 'United Kingdom of Great Britain and Northern Irela');
INSERT INTO beertag.country (country_id, country_name) VALUES (237, 'United States Minor Outlying Islands');
INSERT INTO beertag.country (country_id, country_name) VALUES (236, 'United States of America');
INSERT INTO beertag.country (country_id, country_name) VALUES (238, 'Uruguay');
INSERT INTO beertag.country (country_id, country_name) VALUES (239, 'Uzbekistan');
INSERT INTO beertag.country (country_id, country_name) VALUES (240, 'Vanuatu');
INSERT INTO beertag.country (country_id, country_name) VALUES (241, 'Venezuela (Bolivarian Republic of)');
INSERT INTO beertag.country (country_id, country_name) VALUES (242, 'Viet Nam');
INSERT INTO beertag.country (country_id, country_name) VALUES (243, 'Virgin Islands (British)');
INSERT INTO beertag.country (country_id, country_name) VALUES (244, 'Virgin Islands (U.S.)');
INSERT INTO beertag.country (country_id, country_name) VALUES (245, 'Wallis and Futuna');
INSERT INTO beertag.country (country_id, country_name) VALUES (246, 'Western Sahara');
INSERT INTO beertag.country (country_id, country_name) VALUES (247, 'Yemen');
INSERT INTO beertag.country (country_id, country_name) VALUES (248, 'Zambia');
INSERT INTO beertag.country (country_id, country_name) VALUES (249, 'Zimbabwe');
INSERT INTO beertag.country (country_id, country_name) VALUES (2, 'Åland Islands');

create table brewery
(
    brewery_id   int auto_increment
        primary key,
    brewery_name varchar(255) not null,
    country_id   int          not null,
    constraint brewery_brewery_name_uindex
        unique (brewery_name),
    constraint brewery_country_country_id_fk
        foreign key (country_id) references country (country_id)
);

INSERT INTO beertag.brewery (brewery_id, brewery_name, country_id) VALUES (1, 'McMenamins Mill Creek', 236);
INSERT INTO beertag.brewery (brewery_id, brewery_name, country_id) VALUES (2, 'Tampa Bay Brewing', 236);
INSERT INTO beertag.brewery (brewery_id, brewery_name, country_id) VALUES (3, 'Cervejaria Sudbrack', 32);
INSERT INTO beertag.brewery (brewery_id, brewery_name, country_id) VALUES (4, 'Brouwerij Van Steenberge', 22);
INSERT INTO beertag.brewery (brewery_id, brewery_name, country_id) VALUES (5, 'Brasserie D''Achouffe', 22);
INSERT INTO beertag.brewery (brewery_id, brewery_name, country_id) VALUES (6, 'Radeberger Exportbierbrauerei
', 84);
INSERT INTO beertag.brewery (brewery_id, brewery_name, country_id) VALUES (7, 'Einbecker Brauhaus AG', 84);
INSERT INTO beertag.brewery (brewery_id, brewery_name, country_id) VALUES (8, 'Pivovary Staropramen', 60);
INSERT INTO beertag.brewery (brewery_id, brewery_name, country_id) VALUES (9, 'Plzesk Prazdroj', 60);

create table style
(
    style_id   int auto_increment
        primary key,
    style_name varchar(255) not null
);

INSERT INTO beertag.style (style_id, style_name) VALUES (1, 'Porter');
INSERT INTO beertag.style (style_id, style_name) VALUES (2, 'American-Style India Pale Ale');
INSERT INTO beertag.style (style_id, style_name) VALUES (3, 'South German-Style Weizenbock
');
INSERT INTO beertag.style (style_id, style_name) VALUES (4, 'Other Belgian-Style Ales');
INSERT INTO beertag.style (style_id, style_name) VALUES (5, 'Other style');
INSERT INTO beertag.style (style_id, style_name) VALUES (6, 'German-Style Pilsener');
INSERT INTO beertag.style (style_id, style_name) VALUES (7, 'German-Style Oktoberfest');
INSERT INTO beertag.style (style_id, style_name) VALUES (8, 'German lager');

create table tags
(
    tag_id   int auto_increment
        primary key,
    tag_name varchar(30) not null
);

INSERT INTO beertag.tags (tag_id, tag_name) VALUES (1, '#drink');
INSERT INTO beertag.tags (tag_id, tag_name) VALUES (2, '#beergeek');
INSERT INTO beertag.tags (tag_id, tag_name) VALUES (3, '#food');
INSERT INTO beertag.tags (tag_id, tag_name) VALUES (4, '#beerlover');

create table users
(
    username varchar(50) not null
        primary key,
    password varchar(68) not null,
    enabled  tinyint     not null
);

INSERT INTO beertag.users (username, password, enabled) VALUES ('gosho', '{noop}gosho', 1);
INSERT INTO beertag.users (username, password, enabled) VALUES ('ivan', '{noop}ivan', 1);
INSERT INTO beertag.users (username, password, enabled) VALUES ('pesho', '{noop}pesho', 1);
INSERT INTO beertag.users (username, password, enabled) VALUES ('stamat', '{noop}stamat', 1);
INSERT INTO beertag.users (username, password, enabled) VALUES ('vanko', '{noop}vanko', 1);

create table authorities
(
    username  varchar(50) not null,
    authority varchar(50) not null,
    constraint username_authority
        unique (username, authority),
    constraint authorities_users_username_fk
        foreign key (username) references users (username)
);

INSERT INTO beertag.authorities (username, authority) VALUES ('gosho', 'ROLE_USER');
INSERT INTO beertag.authorities (username, authority) VALUES ('ivan', 'ROLE_USER');
INSERT INTO beertag.authorities (username, authority) VALUES ('pesho', 'ROLE_USER');
INSERT INTO beertag.authorities (username, authority) VALUES ('stamat', 'ROLE_USER');
INSERT INTO beertag.authorities (username, authority) VALUES ('vanko', 'ROLE_ADMIN');

create table user_details
(
    user_id    int auto_increment
        primary key,
    username   varchar(20) not null,
    email      varchar(30) not null,
    first_name varchar(15) null,
    last_name  varchar(15) null,
    constraint user_email_uindex
        unique (email),
    constraint user_details_users_username_fk
        foreign key (username) references users (username)
);

INSERT INTO beertag.user_details (user_id, username, email, first_name, last_name) VALUES (1, 'gosho', 'gosho@gmail.com', 'Georgi', 'Georgiev');
INSERT INTO beertag.user_details (user_id, username, email, first_name, last_name) VALUES (2, 'ivan', 'ivan@gmail.com', 'Ivan', 'Ivanov');
INSERT INTO beertag.user_details (user_id, username, email, first_name, last_name) VALUES (3, 'pesho', 'pesho@gmail.com', 'Petar', 'Petrov');
INSERT INTO beertag.user_details (user_id, username, email, first_name, last_name) VALUES (4, 'stamat', 'stamat@gmail.com', 'Stamat', 'Ivanov');
INSERT INTO beertag.user_details (user_id, username, email, first_name, last_name) VALUES (5, 'vanko', 'vanko@gmail.com', 'Ivan', 'Stamatov');

create table beers
(
    beer_id     int auto_increment
        primary key,
    beer_name   varchar(255) not null,
    description varchar(200) null,
    brewery_id  int          not null,
    style_id    int          not null,
    abv         double       not null,
    picture     varchar(255) null,
    owner_id    int          null,
    constraint beers_brewery_brewery_id_fk
        foreign key (brewery_id) references brewery (brewery_id),
    constraint beers_style_id_fk
        foreign key (style_id) references style (style_id),
    constraint beers_user_id_fk
        foreign key (owner_id) references user_details (user_id)
);

INSERT INTO beertag.beers (beer_id, beer_name, description, brewery_id, style_id, abv, picture, owner_id) VALUES (1, 'Porter New 23', null, 5, 3, 4.5, null, 1);
INSERT INTO beertag.beers (beer_id, beer_name, description, brewery_id, style_id, abv, picture, owner_id) VALUES (2, 'IPA', null, 2, 2, 0, null, 2);
INSERT INTO beertag.beers (beer_id, beer_name, description, brewery_id, style_id, abv, picture, owner_id) VALUES (3, 'Eisenbahn Weizenbock', null, 3, 3, 8, null, 3);
INSERT INTO beertag.beers (beer_id, beer_name, description, brewery_id, style_id, abv, picture, owner_id) VALUES (4, 'Houblon', null, 5, 5, 8, null, 4);
INSERT INTO beertag.beers (beer_id, beer_name, description, brewery_id, style_id, abv, picture, owner_id) VALUES (5, 'Bornem Triple', null, 4, 4, 9, null, 1);
INSERT INTO beertag.beers (beer_id, beer_name, description, brewery_id, style_id, abv, picture, owner_id) VALUES (6, 'Pilsener', null, 6, 6, 4.8, null, 2);
INSERT INTO beertag.beers (beer_id, beer_name, description, brewery_id, style_id, abv, picture, owner_id) VALUES (7, 'Schwarzbier / Dunkel', null, 7, 7, 4.9, null, 3);
INSERT INTO beertag.beers (beer_id, beer_name, description, brewery_id, style_id, abv, picture, owner_id) VALUES (8, 'Staropramen', null, 8, 8, 5, null, 4);
INSERT INTO beertag.beers (beer_id, beer_name, description, brewery_id, style_id, abv, picture, owner_id) VALUES (9, 'Pilsner Urquell', null, 9, 8, 4.4, null, 1);

create table beer_rating
(
    id      int auto_increment
        primary key,
    beer_id int null,
    rating  int null,
    user_id int null,
    constraint beer_rating_beers_beer_id_fk
        foreign key (beer_id) references beers (beer_id),
    constraint beer_rating_user_id_fk
        foreign key (user_id) references user_details (user_id)
);

create index beer_rating_rating_id_fk
    on beer_rating (rating);
    
    
    create table drank_beer_list
(
    beer_id int null,
    user_id int null,
    constraint drunk_beer_list_beers_beer_id_fk
        foreign key (beer_id) references beers (beer_id),
    constraint drunk_beer_list_user_user_id_fk
        foreign key (user_id) references user_details (user_id)
);

create table wish_beer_list
(
    beer_id int not null,
    user_id int not null,
    constraint wish_beer_list_beers_beer_id_fk
        foreign key (beer_id) references beers (beer_id),
    constraint wish_beer_list_user_user_id_fk
        foreign key (user_id) references user_details (user_id)
);

create table beer_tags
(
    beer_id int null,
    tag_id int null,
    constraint beer_tags_beers_beer_id_fk
        foreign key (beer_id) references beers (beer_id),
    constraint beer_tags_tags_id_fk
        foreign key (tag_id) references tags (tag_id)
);
