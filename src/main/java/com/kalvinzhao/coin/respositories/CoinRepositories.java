package com.kalvinzhao.coin.respositories;

import com.kalvinzhao.coin.models.Coin;
import org.springframework.data.repository.CrudRepository;

public interface CoinRepositories extends CrudRepository<Coin,Long> {
}
