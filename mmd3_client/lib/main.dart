import 'package:flutter/material.dart';
import 'package:mmd3_client/common/app.dart';
import 'package:mmd3_client/common/util/desktop_scroll_behavior.dart';

void main() async {
  await App.uc.system.getSystem.invoke();
  runApp(MaterialApp(
    debugShowCheckedModeBanner: false,
    title: "Mmd3 Client",
    scrollBehavior: DesktopScrollBehavior(),
    theme: ThemeData(
      colorScheme: ColorScheme.fromSeed(seedColor: Colors.pink),
      useMaterial3: true,
    ),
    home: Container(
      color: Colors.white,
      child: Center(
        child: ElevatedButton(onPressed: () {}, child: Text("Some thing dump")),
      ),
    ),
  ));
}
