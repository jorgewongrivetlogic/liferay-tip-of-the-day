create table rivetlogic_tipday_TipsOfTheDayCategories (
	groupId LONG not null primary key,
	categories VARCHAR(75) null
);

create table rivetlogic_tipday_TipsOfTheDayUsers (
	tipUserId LONG not null primary key,
	companyId LONG,
	groupId LONG,
	userId LONG,
	status VARCHAR(75) null,
	showAll BOOLEAN
);

create table rivetlogic_tipday_TipsOfTheDayVisited (
	userId LONG not null,
	companyId LONG not null,
	groupId LONG not null,
	tipId VARCHAR(75) not null,
	primary key (userId, companyId, groupId, tipId)
);