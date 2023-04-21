use boza;

CREATE TABLE addreferences (
	reference_id INT PRIMARY KEY auto_increment NOT NULL,
	reference_title VARCHAR (255) NOT NULL,
    reference_year INT NOT NULL,
    reference_pp VARCHAR (255) NOT NULL,
    reference_url VARCHAR (255) NOT NULL,
    authors VARCHAR (255) NOT NULL,
    authors VARCHAR (255),
    publication_id INT,
    FOREIGN KEY (publication_id) REFERENCES publication(publication_id)
);

CREATE TABLE area (
	area_id INT PRIMARY KEY auto_increment NOT NULL,
	area_name VARCHAR (255) NOT NULL,
	research_area_id INT,
    FOREIGN KEY (research_area_id) REFERENCES research_area(research_area_id)
);

CREATE TABLE author (
	author_id INT PRIMARY KEY auto_increment NOT NULL,
	author_name VARCHAR (255) NOT NULL
);

CREATE TABLE editor (
	editor_id INT PRIMARY KEY auto_increment NOT NULL,
	editor_name VARCHAR (255) NOT NULL,
    editor_contact VARCHAR (255) NOT NULL
);

CREATE TABLE pub_auth (
	author_id INT,
    publication_id INT,
    FOREIGN KEY (author_id) REFERENCES author(author_id),
    FOREIGN KEY (publication_id) REFERENCES publication(publication_id)
);

CREATE TABLE publication (
	publication_id INT PRIMARY KEY auto_increment NOT NULL,
	publication_title VARCHAR (255) NOT NULL,
    publication_type VARCHAR (255) NOT NULL,
    publication_pages VARCHAR (255) NOT NULL,
    publication_volume VARCHAR (45) NOT NULL,
    publication_issue VARCHAR (45) NOT NULL,
    publication_month VARCHAR (45) NOT NULL,
    publication_year VARCHAR (45) NOT NULL,
    publication_location VARCHAR (45) NOT NULL,
    venue_id INT,
    FOREIGN KEY (venue_id) REFERENCES venue(venue_id)
);

CREATE TABLE organisation (
	organisation_id INT PRIMARY KEY auto_increment NOT NULL,
    organisation_name VARCHAR (255) NOT NULL,
    organisation_contact VARCHAR (255) NOT NULL,
    organisation_homeOffice VARCHAR (255) NOT NULL
);

CREATE TABLE organiser (
	organiser_id INT PRIMARY KEY auto_increment NOT NULL,
    organiser_name VARCHAR (255) NOT NULL,
    organiser_contact VARCHAR (255) NOT NULL
);

CREATE TABLE publisher (
	publisher_id INT PRIMARY KEY auto_increment NOT NULL,
	publisher_name VARCHAR (255) NOT NULL,
    publisher_email VARCHAR (255) NOT NULL,
    publisher_location VARCHAR (255) NOT NULL
);

CREATE TABLE research_area (
	research_area_id INT PRIMARY KEY auto_increment NOT NULL,
	research_area_name VARCHAR (255) NOT NULL
);

CREATE TABLE venue (
	venue_id INT PRIMARY KEY auto_increment NOT NULL,
	venue_name VARCHAR (255) NOT NULL,
    venue_location VARCHAR (255) NOT NULL
);

CREATE TABLE venue_research (
	research_id INT,
	venue_id INT,
	FOREIGN KEY (research_id) REFERENCES research_area(research_id),
    FOREIGN KEY (venue_id) REFERENCES venue(venue_id)
);