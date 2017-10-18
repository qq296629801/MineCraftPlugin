package cn.ymsys.example;

import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;

public class MyListener implements Listener {
	private int flag = 0;

	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		Player player = e.getPlayer();
		player.sendMessage("欢迎加入小米的服务器" + player.getName());
	}

	@EventHandler
	public void onInteract(PlayerInteractEvent e) {
		Player player = e.getPlayer();
		if (e.getMaterial() == Material.TORCH) {
			if (e.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
				try {
					player.sendMessage(Led());
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
	}

	public String Led() throws IOException {
		StringBuffer s = new StringBuffer();
		String open = "http://192.168.0.111/test.php?status=0&id=1";
		String close = "http://192.168.0.111/test.php?status=1&id=1";
		if (flag == 0) {
			URL url = new URL(open);
			url.openConnection();
			Scanner sc = new Scanner(url.openStream());
			while (sc.hasNext()) {
				s.append(sc.nextLine());
			}
			flag = 1;
		} else {
			URL url = new URL(close);
			url.openConnection();
			Scanner sc = new Scanner(url.openStream());
			while (sc.hasNext()) {
				s.append(sc.nextLine());
			}
			flag = 0;
		}
		return s.toString();
	}
}
