package bugtracker.bugtracker.bugtracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

public class BugRepository {
}
public interface BugRepository<Bug> extends JpaRepository<Bug, Long> {}
