INSERT INTO exercises (id, name, description, level, primary_muscle, created_at, created_by, updated_at, updated_by, active, deleted_at, deleted_by) VALUES
('902c31ad-ff45-4303-86e4-411da39f476c', 'chest', 'chest exercise' ,'BEGINNER', 'CHEST', NOW(), 'n1b3lung0', null, null, TRUE, null, null),
('4c80c1d0-0ac5-4381-af8f-12189addecf3', 'triceps', 'triceps exercise' ,'BEGINNER', 'CHEST',  NOW(), 'n1b3lung0', null, null, TRUE, null, null),
('b88b3af2-d47a-462a-8b51-e7f3ce3fd0b5', 'biceps', 'biceps exercise' ,'BEGINNER', 'CHEST',  NOW(), 'n1b3lung0', null, null, TRUE, null, null);

INSERT INTO routines(exercise_id, routine) VALUES
('902c31ad-ff45-4303-86e4-411da39f476c', 'PUSH'),
('902c31ad-ff45-4303-86e4-411da39f476c', 'PULL'),
('4c80c1d0-0ac5-4381-af8f-12189addecf3', 'PUSH'),
('b88b3af2-d47a-462a-8b51-e7f3ce3fd0b5', 'PUSH');

INSERT INTO secondary_muscles(exercise_id, secondary_muscle) VALUES
('902c31ad-ff45-4303-86e4-411da39f476c', 'BICEPS'),
('902c31ad-ff45-4303-86e4-411da39f476c', 'TRICEPS'),
('4c80c1d0-0ac5-4381-af8f-12189addecf3', 'BICEPS'),
('b88b3af2-d47a-462a-8b51-e7f3ce3fd0b5', 'BICEPS');