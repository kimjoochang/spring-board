package joochang.project.domain;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Boards")
@Getter
public class Board {
    @Id
    @GeneratedValue
    @Column(name = "board_no")
    private Long boardNo;

    private String title;

    private String context;

    @ManyToOne
    private Member writer;

    private Date creationDate;

    private Date updateDate;

    // 연관관계 메서드
    public void setWriter(Member writer) {
        this.writer = writer;
        writer.getBoards().add(this);
    }
}
