package com.example.cinemaAppBackend.DTOs;

import com.example.cinemaAppBackend.Enums;
import com.example.cinemaAppBackend.JPA.CinemaUserEntity;
import com.fasterxml.jackson.databind.JsonNode;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

public class SeatDTO {

//    @NotNull
//    @NotEmpty(message = "Seat type required")
//    @Enumerated(EnumType.ORDINAL)
//    private Enums.SeatType seatType;
    @NotNull
    @NotEmpty(message = "Movie Id required")
    private int cinemaId;

    private long movieId;


    private List<JsonNode> seatDetails;

    public int getCinemaId() {
        return cinemaId;
    }

    public void setCinemaId(int cinemaId) {
        this.cinemaId = cinemaId;
    }

    public long getMovieId() {
        return movieId;
    }

    public void setMovieId(long movieId) {
        this.movieId = movieId;
    }

    public List<JsonNode> getSeatDetails() {
        return seatDetails;
    }

    public void setSeatDetails(List<JsonNode> seatDetails) {
        this.seatDetails = seatDetails;
    }
}

/*const MyTable = () => {
  const [dataSource, setDataSource] = useState(data);

  const handleSeatChange = (value, key) => {
    const newData = [...dataSource];
    const index = newData.findIndex((item) => key === item.key);
    const item = newData[index];
    newData.splice(index, 1, { ...item, noOfSeats: value });
    setDataSource(newData);
  };

  const handlePriceChange = (value, key) => {
    const newData = [...dataSource];
    const index = newData.findIndex((item) => key === item.key);
    const item = newData[index];
    newData.splice(index, 1, { ...item, price: value });
    setDataSource(newData);
  };

  return <Table dataSource={dataSource} columns={columns} />;
};

export default MyTable;*/