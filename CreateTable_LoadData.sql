USE [TESTDB]
GO

/****** Object:  Table [dbo].[tms_tasks]    Script Date: 1/12/2025 2:45:17 AM ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[tms_tasks](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[title] [varchar](50) NOT NULL,
	[description] [varchar](255) NULL,
	[status] [char](1) NULL,
	[start_date] [datetime] NOT NULL,
	[end_date] [datetime] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO

ALTER TABLE [dbo].[tms_tasks] ADD  DEFAULT (getdate()) FOR [start_date]
GO

ALTER TABLE [dbo].[tms_tasks] ADD  DEFAULT (getdate()) FOR [end_date]
GO

CREATE UNIQUE INDEX idx_UniqueId
ON tms_tasks (id);

CREATE INDEX idx_status
ON tms_tasks (status);

INSERT INTO [tms_tasks] (title, description, status, start_date, end_date)
VALUES
    ('Complete Documentation', 'Finalize the project documentation for the upcoming release.', 'P', '2025-01-11 08:00:00.000', '2025-01-11 10:00:00.000'),
    ('Review Code', 'Review the code for the new feature implementation and fix any issues.', 'P', '2025-01-11 10:15:00.000', '2025-01-11 12:15:00.000'),
    ('Team Meeting', 'Attend the daily stand-up meeting to discuss project progress and blockers.', 'P', '2025-01-11 12:30:00.000', '2025-01-11 13:00:00.000'),
    ('Bug Fixes', 'Fix any high-priority bugs reported in the production environment.', 'P', '2025-01-11 13:15:00.000', '2025-01-11 15:00:00.000'),
    ('API Integration', 'Integrate third-party API to the existing project and test its functionality.', 'P', '2025-01-11 15:15:00.000', '2025-01-11 17:00:00.000'),
    ('Database Cleanup', 'Optimize the database and remove any redundant data entries.', 'P', '2025-01-11 17:15:00.000', '2025-01-11 19:00:00.000'),
    ('UI/UX Review', 'Review the UI/UX design of the latest feature with the design team.', 'P', '2025-01-11 19:15:00.000', '2025-01-11 20:00:00.000'),
    ('Update Dependencies', 'Update the project dependencies to their latest versions.', 'P', '2025-01-11 20:15:00.000', '2025-01-11 22:00:00.000'),
    ('Test Automation', 'Create automated tests for the newly implemented feature.', 'P', '2025-01-11 22:15:00.000', '2025-01-11 23:59:59.999'),
    ('Server Maintenance', 'Perform maintenance tasks on the server, including backups and updates.', 'P', '2025-01-11 08:00:00.000', '2025-01-11 09:00:00.000'),
    ('Client Feedback', 'Review and implement client feedback for the latest product release.', 'P', '2025-01-11 10:00:00.000', '2025-01-11 11:00:00.000'),
    ('Deploy to Staging', 'Deploy the latest version of the project to the staging environment.', 'P', '2025-01-11 11:15:00.000', '2025-01-11 13:00:00.000'),
    ('Security Audit', 'Perform a security audit of the application and address any vulnerabilities.', 'P', '2025-01-11 13:15:00.000', '2025-01-11 15:00:00.000'),
    ('Performance Monitoring', 'Monitor the application performance to identify any bottlenecks or issues.', 'P', '2025-01-11 15:15:00.000', '2025-01-11 17:00:00.000'),
    ('Documentation Update', 'Update the internal documentation to reflect the latest changes in the project.', 'P', '2025-01-11 17:15:00.000', '2025-01-11 19:00:00.000');