create index IX_8C244FB1 on rivetlogic_tod_TipsOfTheDayUsers (companyId, groupId);
create index IX_F37366EB on rivetlogic_tod_TipsOfTheDayUsers (companyId, groupId, userId);
create index IX_8AB39715 on rivetlogic_tod_TipsOfTheDayUsers (groupId, userId);

create index IX_A54B504D on rivetlogic_tod_TipsOfTheDayVisited (companyId, groupId, userId);