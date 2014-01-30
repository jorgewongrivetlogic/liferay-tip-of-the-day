create table rivetlogic_tod_TipsOfTheDayCategories (
	groupId LONG not null primary key,
	categories VARCHAR(75) null
);

create table rivetlogic_tod_TipsOfTheDayUsers (
	tipUserId LONG not null primary key,
	companyId LONG,
	groupId LONG,
	userId LONG,
	status VARCHAR(75) null
);